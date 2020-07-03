package com.example.parayo.domain.product

import android.net.Uri
import com.example.parayo.util.Result

interface ProductDataSource {

    suspend fun uploadProductImage(imageUri: Uri): Result<Boolean>
}