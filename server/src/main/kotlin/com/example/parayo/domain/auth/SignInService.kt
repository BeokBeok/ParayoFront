package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.User
import com.example.parayo.domain.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignInService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun signIn(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByEmail(signInRequest.email.toLowerCase())
            ?: throw ParayoException("로그인 정보를 확인해주세요.")

        if (isNotValidPassword(signInRequest.password, user.password)) {
            throw ParayoException("로그인 정보를 확인해주세요.")
        }

        return responseWithTokens(user)
    }

    private fun isNotValidPassword(plain: String, hashed: String) = BCrypt.checkpw(plain, hashed).not()

    private fun responseWithTokens(user: User): SignInResponse {
        if (user.id == 0L) {
            throw IllegalStateException("user.id 없음")
        }

        return SignInResponse(
            token = JWTUtil.createToken(user.email),
            refreshToken = JWTUtil.createRefreshToken(user.email),
            userName = user.name,
            userId = user.id
        )
    }
}