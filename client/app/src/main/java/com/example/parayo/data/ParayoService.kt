package com.example.parayo.data

import com.example.parayo.data.model.ParayoResponse
import retrofit2.http.GET

interface ParayoService {

    @GET("api/v1/hello")
    suspend fun hello(): ParayoResponse
}