package com.alonsogp.nhl_app.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageViewEx {
    fun ImageView.loadUrl(urlImage: String) {
        Glide.with(this).load(urlImage).into(this)
    }
}