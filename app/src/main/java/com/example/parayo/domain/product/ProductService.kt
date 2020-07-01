package com.example.parayo.domain.product

import com.example.parayo.common.Response
import com.example.parayo.domain.product.entity.ProductImageUploadResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ProductService {

    @Multipart
    @POST("/api/v1/product_images")
    suspend fun uploadProductImages(
        @Part images: MultipartBody.Part
    ): Response<ProductImageUploadResponse>
}