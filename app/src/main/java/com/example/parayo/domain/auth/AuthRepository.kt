package com.example.parayo.domain.auth

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.auth.model.AuthRequest
import com.example.parayo.auth.model.mapToPresenter
import com.example.parayo.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) : AuthDataSource {

    private val ioDispatcher = Dispatchers.IO

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

    override suspend fun doSignIn(authRequest: AuthRequest): Result<AuthModel> =
        withContext(ioDispatcher) {
            return@withContext try {
                println("${Thread.currentThread().name}")
                val result = authService.signIn(authRequest)
                if (result.success) {
                    Result.Success(result.data.mapToPresenter() ?: AuthModel())
                } else {
                    Result.Failure(IllegalStateException(result.message))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
}