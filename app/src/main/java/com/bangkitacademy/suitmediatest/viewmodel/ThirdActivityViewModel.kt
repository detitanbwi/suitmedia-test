package com.bangkitacademy.suitmediatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bangkitacademy.suitmediatest.data.response.User
import com.bangkitacademy.suitmediatest.data.retrofit.Repository


class ThirdActivityViewModel(userRepository: Repository) : ViewModel() {
    val user: LiveData<PagingData<User>> =
        userRepository.getUser().cachedIn(viewModelScope)
}