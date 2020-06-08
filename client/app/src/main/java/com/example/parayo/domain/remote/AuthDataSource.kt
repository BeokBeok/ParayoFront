package com.example.parayo.domain.remote

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.domain.entity.AuthRequest
import com.example.parayo.util.Result

interface AuthDataSource {

    suspend fun doSignUp(authRequest: AuthRequest): Result<AuthModel>
}