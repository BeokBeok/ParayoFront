package com.example.parayo.domain.auth

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.auth.model.AuthRequest
import com.example.parayo.common.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/users")
    suspend fun signUp(@Body authRequest: AuthRequest): Response<AuthModel>

    @POST("api/v1/signin")
    suspend fun signIn(@Body authRequest: AuthRequest): Response<AuthModel>
}