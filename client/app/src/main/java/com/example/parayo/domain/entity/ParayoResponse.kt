package com.example.parayo.domain.entity

import com.example.parayo.common.ParayoModel
import com.google.gson.annotations.SerializedName

data class ParayoResponse(

	@SerializedName("data")
	val data: Any? = null,

	@SerializedName("success")
	val success: Boolean = false,

	@SerializedName("message")
	val message: String? = null
)

fun ParayoResponse.mapToModel(): ParayoModel = ParayoModel(data = data as? String ?: "")
