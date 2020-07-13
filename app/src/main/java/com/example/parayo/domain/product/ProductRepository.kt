package com.example.parayo.domain.product

import android.net.Uri
import com.example.parayo.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) :
    ProductDataSource {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun uploadProductImage(imageUri: Uri): Result<Boolean> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = productService.uploadProductImages(makeImagePart(imageUri))
                if (result.success) {
                    Result.Success(true)
                } else {
                    Result.Failure(IllegalStateException(result.message))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }

    private fun makeImagePart(imageUri: Uri): MultipartBody.Part {
        val (mediaType, imageFile) = MediaType.parse("multipart/form-data") to File(imageUri.toString())
        val body = RequestBody.create(mediaType, imageFile)

        return MultipartBody.Part
            .createFormData("image", imageFile.name, body)
    }
}