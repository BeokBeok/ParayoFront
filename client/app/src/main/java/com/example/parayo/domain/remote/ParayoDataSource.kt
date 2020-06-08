package com.example.parayo.domain.remote

import com.example.parayo.common.ParayoModel
import com.example.parayo.domain.entity.ParayoSignUpRequest
import com.example.parayo.util.Result

interface ParayoDataSource {

    suspend fun doSignUp(signUpRequest: ParayoSignUpRequest): Result<ParayoModel>
}