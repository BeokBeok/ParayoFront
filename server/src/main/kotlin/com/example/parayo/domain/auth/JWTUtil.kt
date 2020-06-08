package com.example.parayo.domain.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

object JWTUtil {

    private const val ISSUER = "Parayo"
    private const val SUBJECT = "Auth"
    private const val EXPIRE_TIME = 60L * 60 * 2 * 1_000 // 2 hour
    private const val REFRESH_EXPIRE_TIME = 60L * 60 * 24 * 30 * 1_000 // 30 day

    private const val SECRET = "access"
    private val algorithm = Algorithm.HMAC256(SECRET)

    private const val EMAIL = "email"

    private const val REFRESH_SECRET = "refresh"
    private val refreshAlgorith = Algorithm.HMAC256(REFRESH_SECRET)

    fun createToken(email: String): String {
        val createdDate = Date()
        return JWT.create()
            .withIssuer(ISSUER)
            .withSubject(SUBJECT)
            .withIssuedAt(createdDate)
            .withExpiresAt(Date(createdDate.time + EXPIRE_TIME))
            .withClaim(EMAIL, email)
            .sign(algorithm)
    }

    fun createRefreshToken(email: String): String {
        val createdDate = Date()
        return JWT.create()
            .withIssuer(ISSUER)
            .withSubject(SUBJECT)
            .withIssuedAt(createdDate)
            .withExpiresAt(Date(createdDate.time + REFRESH_EXPIRE_TIME))
            .withClaim(EMAIL, email)
            .sign(refreshAlgorith)
    }
}