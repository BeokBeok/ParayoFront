package com.example.parayo.ext

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.parayo.wrapper.BeokImagePicker

@BindingAdapter("bind:index", "bind:showImagePicker", requireAll = true)
fun showImagePicker(imageView: ImageView, index: Int, imgUpload: (index: Int, uri: Uri) -> Unit) =
    imageView.setOnClickListener {
        BeokImagePicker.showSingleImagePicker(imageView, index, imgUpload)
    }