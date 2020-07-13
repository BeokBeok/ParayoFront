package com.example.parayo.ext

import android.net.Uri
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.example.parayo.wrapper.BeokImagePicker
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("bind:index", "bind:showImagePicker", requireAll = true)
fun showImagePicker(imageView: ImageView, index: Int, imgUpload: (index: Int, uri: Uri) -> Unit) =
    imageView.setOnClickListener {
        BeokImagePicker.showSingleImagePicker(imageView, index, imgUpload)
    }

@BindingAdapter("bind:textInputLayoutErrorText")
fun textInputLayoutErrorText(textInputLayout: TextInputLayout, errMsg: String) {
    textInputLayout.editText?.addTextChangedListener {
        textInputLayout.error = if (it.toString().length > textInputLayout.counterMaxLength) {
            errMsg
        } else {
            null
        }
    }
}