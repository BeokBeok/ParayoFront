package com.example.parayo.domain

import com.example.parayo.common.ParayoModel
import com.example.parayo.domain.entity.ParayoAuthRequest
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

    override suspend fun doSignUp(authRequest: ParayoAuthRequest): Result<ParayoModel> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = parayoService.signUp(authRequest)
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