package com.example.parayo.repository.source

import com.example.parayo.repository.model.ParayoResponse

interface ParayoDataSource {

    suspend fun getHello(): ParayoResponse
}