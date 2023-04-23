package com.alonsogp.nhl_app.app.presentation.loading

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.app.extensions.gone
import com.alonsogp.nhl_app.app.extensions.visible

class LoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_loading, this, true)
    }

    fun show(){
        visible()
    }

    fun hide(){
        gone()
    }
}