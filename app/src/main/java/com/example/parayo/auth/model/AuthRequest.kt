package com.example.parayo.auth.model

import android.util.Patterns

data class AuthRequest(
    val email: String,
    val password: String,
    val name: String
) {

    fun isNotValidEmail() =
        email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword() = password.isEmpty() || password.length !in 8..20

    fun isNotValidName() = name.isEmpty() || name.length !in 2..20
}