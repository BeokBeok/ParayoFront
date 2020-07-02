package com.example.parayo.domain.auth.entity

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("token")
    val token: String? = null,

    @SerializedName("refreshToken")
    val refreshToken: String? = null,

    @SerializedName("userName")
    val userName: String? = null,

    @SerializedName("userId")
    val userId: Long? = null
)