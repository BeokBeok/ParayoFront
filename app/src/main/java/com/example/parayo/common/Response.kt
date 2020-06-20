package com.example.parayo.common

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @SerializedName("data")
    val data: T? = null,

    @SerializedName("success")
    val success: Boolean = false,

    @SerializedName("message")
    val message: String? = null
)