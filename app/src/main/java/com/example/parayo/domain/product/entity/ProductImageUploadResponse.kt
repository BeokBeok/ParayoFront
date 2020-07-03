package com.example.parayo.domain.product.entity

import com.google.gson.annotations.SerializedName

class ProductImageUploadResponse(
    @SerializedName("productImageId")
    val productImageId: Long,

    @SerializedName("filePath")
    val filePath: String
)