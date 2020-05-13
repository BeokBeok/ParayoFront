package com.example.parayo.common

data class ApiResponse(
    val success: Boolean,
    val data: Any? = null,
    val message: String? = null
) {

    companion object {

        fun ok(data: Any? = null) = ApiResponse(
            success = true,
            data = data
        )

        fun error(message: String? = null) = ApiResponse(
            success = false,
            message = message
        )
    }
}