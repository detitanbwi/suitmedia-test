package com.bangkitacademy.suitmediatest.data.response

data class ApiResponse(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<User>,
    val support: Support
)

