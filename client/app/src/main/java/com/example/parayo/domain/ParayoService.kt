package com.example.parayo.domain

import com.example.parayo.domain.entity.ParayoResponse
import com.example.parayo.domain.entity.ParayoSignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ParayoService {

    @POST("api/v1/users")
    suspend fun signUp(@Body signUpRequest: ParayoSignUpRequest): ParayoResponse
}