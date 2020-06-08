package com.example.parayo.domain.remote

import com.example.parayo.common.ParayoModel
import com.example.parayo.domain.entity.ParayoAuthRequest
import com.example.parayo.util.Result

interface ParayoDataSource {

    suspend fun doSignUp(authRequest: ParayoAuthRequest): Result<ParayoModel>
}