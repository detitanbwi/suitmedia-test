package com.bangkitacademy.suitmediatest.data.retrofit

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.bangkitacademy.suitmediatest.data.UserPagingSource
import com.bangkitacademy.suitmediatest.data.response.User


class Repository(private val apiService: ApiService) {
    fun getUser(): LiveData<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}