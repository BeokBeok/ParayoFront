package com.example.parayo.data.source

import com.example.parayo.data.model.ParayoResponse

interface ParayoDataSource {

    suspend fun getHello(): ParayoResponse
}