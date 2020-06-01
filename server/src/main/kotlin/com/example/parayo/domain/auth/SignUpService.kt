package com.example.parayo.domain.auth

import com.example.parayo.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignUpService @Autowired constructor(
    private val userRepository: UserRepository
)