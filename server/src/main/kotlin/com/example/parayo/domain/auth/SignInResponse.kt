package com.example.parayo.domain.auth

data class SignInResponse(
    val token: String,
    val refreshToken: String,
    val userName: String, // TODO 사용자 이름을 토큰의 Claim 에 넣고 App 단에서 토큰 파싱
    val userId: Long
)