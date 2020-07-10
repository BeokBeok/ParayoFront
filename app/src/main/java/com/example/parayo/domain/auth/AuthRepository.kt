package com.example.parayo.domain.auth

import com.example.parayo.auth.model.AuthModel
import com.example.parayo.auth.model.AuthRequest
import com.example.parayo.auth.model.mapToPresenter
import com.example.parayo.util.Result
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) : AuthDataSource {

    override suspend fun doSignUp(authRequest: AuthRequest): Result<AuthModel> = try {
        val result = authService.signUp(authRequest)
        if (result.success) {
            Result.Success(AuthModel())
        } else {
            Result.Failure(IllegalStateException(result.message))
        }
    } catch (e: Exception) {
        Result.Failure(e)
    }

    override suspend fun doSignIn(authRequest: AuthRequest): Result<AuthModel> = try {
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