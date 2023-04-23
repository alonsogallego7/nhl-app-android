package com.alonsogp.nhl_app.app.extensions

import android.widget.ImageView
import com.alonsogp.nhl_app.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrl(urlImage: String) {
    Glide.with(this).load(urlImage).into(this)
}

fun ImageView.loadUrlPlayer(urlImage: String) {
    Glide.with(this).load(urlImage).placeholder(R.drawable.img_player_placeholder).into(this)
}


