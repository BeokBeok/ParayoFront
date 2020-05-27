package com.example.parayo.repository

import retrofit2.http.GET

interface ParayoService {

    @GET("api/v1/hello")
    suspend fun hello(): ParayoResponse
}