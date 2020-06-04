package com.example.parayo.data.model

import com.google.gson.annotations.SerializedName

data class ParayoResponse(

	@SerializedName("data")
	val data: String? = null,

	@SerializedName("success")
	val success: Boolean? = null,

	@SerializedName("message")
	val message: String? = null
)
