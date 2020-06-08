package com.example.parayo.domain.entity

import android.util.Patterns

data class ParayoAuthRequest(
    val email: String?,
    val password: String?,
    val name: String?
) {

    fun isNotValidEmail() =
        email.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() = password.isNullOrEmpty() || password.length !in 8..20

    fun isNotValidName() = name.isNullOrEmpty() || name.length !in 2..20
}