package com.example.parayo.domain

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.common.Response
import com.example.parayo.domain.entity.AuthRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/users")
    suspend fun signUp(@Body authRequest: AuthRequest): Response<AuthModel>

    @POST("api/v1/signin")
    suspend fun signIn(@Body authRequest: AuthRequest): Response<AuthModel>
}