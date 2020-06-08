package com.example.parayo.auth.model

data class AuthModel(
    val token: String = "",
    val refreshToken: String = "",
    val userName: String = "",
    val userId: Long = -1L
)