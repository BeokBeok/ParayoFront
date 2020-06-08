package com.example.parayo.domain.entity

import com.example.parayo.auth.model.AuthModel
import com.google.gson.annotations.SerializedName

data class Response(

	@SerializedName("data")
	val data: Any? = null,

	@SerializedName("success")
	val success: Boolean = false,

	@SerializedName("message")
	val message: String? = null
)

fun Response.mapToModel(): AuthModel =
	AuthModel(data = data as? String ?: "")
