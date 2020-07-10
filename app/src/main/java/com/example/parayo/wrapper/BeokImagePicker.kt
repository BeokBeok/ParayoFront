package com.example.parayo.wrapper

import android.net.Uri
import android.widget.ImageView
import gun0912.tedimagepicker.builder.TedImagePicker

object BeokImagePicker {

    fun showSingleImagePicker(
        imageView: ImageView,
        index: Int,
        imageUpload: (index: Int, uri: Uri) -> Unit
    ) {
        TedImagePicker.with(imageView.context).start { imageUpload.invoke(index, it) }
    }
}