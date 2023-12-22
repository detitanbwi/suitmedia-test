package com.bangkitacademy.suitmediatest.data.injection

import android.content.Context
import com.bangkitacademy.suitmediatest.data.retrofit.ApiConfig
import com.bangkitacademy.suitmediatest.data.retrofit.Repository

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository(apiService)
    }
}