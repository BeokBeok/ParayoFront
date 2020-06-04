package com.example.parayo.data.source

interface ParayoDataSource {

    suspend fun getHello(): com.example.parayo.data.model.ParayoResponse
}