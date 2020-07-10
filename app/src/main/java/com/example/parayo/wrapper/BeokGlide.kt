package com.example.parayo.wrapper

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

object BeokGlide {

    fun srcWithGlide(imageView: ImageView, uri: Uri) {
        Glide.with(imageView)
            .load(uri)
            .placeholder(android.R.drawable.ic_menu_help)
            .into(imageView)
    }
}