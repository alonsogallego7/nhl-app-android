package com.alonsogp.nhl_app.features.stats.presentation.adapter

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.svg.GlideApp
import com.alonsogp.nhl_app.app.extensions.svg.SvgSoftwareLayerSetter
import com.alonsogp.nhl_app.databinding.ViewItemStatsBinding
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import com.bumptech.glide.RequestBuilder

class StatsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var requestBuilder: RequestBuilder<PictureDrawable>? = null
    private var imageViewNet: ImageView? = null

    fun bind(team: TeamOneStatModel, position: Int) {
        val binding = ViewItemStatsBinding.bind(view)
        val position = position + 1
        Log.d("@dev", "$team")
        imageViewNet = binding.teamLogo

        requestBuilder = GlideApp.with(binding.root.context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())

        loadNet("https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/${team.id}.svg")

        binding.teamPosition.text = position.toString()
        binding.teamName.text = team.name
        binding.teamStat.text = team.stat
    }

    private fun loadNet(url: String) {
        val uri: Uri = Uri.parse(url)
        if (imageViewNet != null) {
            requestBuilder?.load(uri)?.into(imageViewNet!!)
        }
    }
}