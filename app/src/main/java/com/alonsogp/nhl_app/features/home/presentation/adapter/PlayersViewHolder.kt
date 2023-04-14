package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.graphics.drawable.PictureDrawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.svg.GlideApp
import com.alonsogp.nhl_app.app.extensions.svg.SvgSoftwareLayerSetter
import com.alonsogp.nhl_app.databinding.ViewItemTeamsBinding
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import com.bumptech.glide.RequestBuilder

class PlayersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var requestBuilder: RequestBuilder<PictureDrawable>? = null
    private var imageViewNet: ImageView? = null

    fun bind(team: TeamModel, itemClick: ((Int) -> Unit)?) {
        val binding = ViewItemTeamsBinding.bind(view)

        imageViewNet = binding.teamLogo

        requestBuilder = GlideApp.with(binding.root.context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())

        loadNet(team.logoUrl)
        binding.teamName.text = team.name
        binding.teamAbbreviation.text = team.abbreviation

        view.setOnClickListener {
            itemClick?.invoke(team.id)
        }
    }