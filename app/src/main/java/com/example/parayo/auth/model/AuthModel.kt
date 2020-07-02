package com.example.parayo.auth.model

import com.example.parayo.domain.auth.entity.AuthResponse

data class AuthModel(
    val token: String = "",
    val refreshToken: String = "",
    val userName: String = "",
    val userId: Long = -1L
)

fun AuthResponse?.mapToPresenter() = this?.let {
    AuthModel(
        token = token ?: "",
        refreshToken = refreshToken ?: "",
        userName = userName ?: "",
        userId = userId ?: -1L
    )
}