package com.example.parayo.domain.auth

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.domain.auth.entity.AuthRequest
import com.example.parayo.util.Result

interface AuthDataSource {

    suspend fun doSignUp(authRequest: AuthRequest): Result<AuthModel>

    suspend fun doSignIn(authRequest: AuthRequest): Result<AuthModel>
}