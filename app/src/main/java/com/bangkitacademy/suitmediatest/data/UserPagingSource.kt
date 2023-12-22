package com.bangkitacademy.suitmediatest.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bangkitacademy.suitmediatest.data.response.User
import com.bangkitacademy.suitmediatest.data.retrofit.ApiService

class UserPagingSource(private val apiService: ApiService) : PagingSource<Int, User>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val page = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getUsers(page, params.loadSize)

            LoadResult.Page(
                data = responseData.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (responseData.data.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

}