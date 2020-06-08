package com.example.parayo.domain

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.domain.entity.AuthRequest
import com.example.parayo.domain.remote.AuthDataSource
import com.example.parayo.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) :
    AuthDataSource {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun doSignUp(authRequest: AuthRequest): Result<AuthModel> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = authService.signUp(authRequest)
                if (result.success) {
                    Result.Success(AuthModel())
                } else {
                    Result.Failure(IllegalStateException(result.message))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
}