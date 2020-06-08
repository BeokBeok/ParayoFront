package com.example.parayo.domain

import com.example.parayo.domain.entity.ParayoAuthRequest
import com.example.parayo.domain.entity.ParayoResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ParayoService {

    @POST("api/v1/users")
    suspend fun signUp(@Body authRequest: ParayoAuthRequest): ParayoResponse
}