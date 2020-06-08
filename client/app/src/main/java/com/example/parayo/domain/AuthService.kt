package com.example.parayo.domain

import com.example.parayo.domain.entity.AuthRequest
import com.example.parayo.domain.entity.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/users")
    suspend fun signUp(@Body authRequest: AuthRequest): Response
}