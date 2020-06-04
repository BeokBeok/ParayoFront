package com.example.parayo.data

import retrofit2.http.GET

interface ParayoService {

    @GET("api/v1/hello")
    suspend fun hello(): com.example.parayo.data.model.ParayoResponse
}