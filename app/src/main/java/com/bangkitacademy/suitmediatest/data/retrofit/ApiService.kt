package com.bangkitacademy.suitmediatest.data.retrofit

import com.bangkitacademy.suitmediatest.data.response.UserResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 6
    ): UserResponse
}
