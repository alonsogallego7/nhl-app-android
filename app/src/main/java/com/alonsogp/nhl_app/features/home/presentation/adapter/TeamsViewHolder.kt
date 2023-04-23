package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.presentation.glide.SvgSoftwareLayerSetter
import com.alonsogp.nhl_app.databinding.ViewItemTeamsBinding
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder


class TeamsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var requestBuilder: RequestBuilder<PictureDrawable>? = null
    private var imageViewNet: ImageView? = null

    fun bind(team: TeamModel, itemClick: ((Int) -> Unit)?) {
        val binding = ViewItemTeamsBinding.bind(view)

        imageViewNet = binding.teamLogo

        requestBuilder = Glide.with(binding.root.context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())

        loadNet(team.logoUrl)
        binding.teamName.text = team.name
        binding.teamAbbreviation.text = team.abbreviation

        view.setOnClickListener {
            itemClick?.invoke(team.id)
        }
    }

    private fun loadNet(url: String) {
        val uri: Uri = Uri.parse(url)
        if (imageViewNet != null) {
            requestBuilder?.load(uri)?.into(imageViewNet!!)
        }
    }
}