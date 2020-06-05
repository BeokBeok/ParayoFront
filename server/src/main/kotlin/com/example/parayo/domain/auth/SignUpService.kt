package com.example.parayo.domain.auth

import com.example.parayo.common.ParayoException
import com.example.parayo.domain.User
import com.example.parayo.domain.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignUpService @Autowired constructor(
    private val userRepository: UserRepository
) {
    private val IS_VALID_EMAIL_REGEX by lazy {
        "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}\$".toRegex()
    }

    fun signUp(signUpRequest: SignUpRequest) {
        validateRequest(signUpRequest)
        checkDuplicates(signUpRequest.email)
        registerUser(signUpRequest)
    }

    private fun validateRequest(signUpRequest: SignUpRequest) {
        signUpRequest.run {
            validateEmail(email)
            validateName(name)
            validatePassword(password)
        }
    }

    private fun validateEmail(email: String) {
        if (!IS_VALID_EMAIL_REGEX.matches(email)) {
            throw ParayoException("이메일 형식이 올바르지 않습니다.")
        }
    }

    private fun validateName(name: String) {
        if (name.trim().length !in 2..20) {
            throw ParayoException("이름은 2자 이상 20자 이하여야 합니다.")
        }
    }

    private fun validatePassword(password: String) {
        if (password.trim().length !in 8..20) {
            throw ParayoException("비밀번호는 공백을 제외하고 8자 이상 20자 이하여야 합니다.")
        }
    }

    private fun checkDuplicates(email: String) {
        userRepository.findByEmail(email)?.let {
            throw ParayoException("이미 사용 중인 이메일입니다.")
        }
    }

    private fun registerUser(signUpRequest: SignUpRequest) =
        with(signUpRequest) {
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
            val user = User(email, hashedPassword, name)
            userRepository.save(user)
        }
}