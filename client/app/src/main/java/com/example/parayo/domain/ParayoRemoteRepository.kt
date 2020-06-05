package com.example.parayo.domain

import com.example.parayo.common.ParayoModel
import com.example.parayo.domain.entity.ParayoResponse
import com.example.parayo.domain.entity.ParayoSignUpRequest
import com.example.parayo.domain.entity.mapToModel
import com.example.parayo.domain.remote.ParayoDataSource
import com.example.parayo.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParayoRemoteRepository @Inject constructor(private val parayoService: ParayoService) :
    ParayoDataSource {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getHello(): ParayoResponse =
        withContext(ioDispatcher) {
            parayoService.hello()
        }

    override suspend fun doSignUp(signUpRequest: ParayoSignUpRequest): Result<ParayoModel> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = parayoService.signUp(signUpRequest)
                if (result.success) {
                    Result.Success(result.mapToModel())
                } else {
                    Result.Failure(IllegalStateException(result.message))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
}