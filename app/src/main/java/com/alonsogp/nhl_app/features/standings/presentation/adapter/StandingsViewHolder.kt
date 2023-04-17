package com.alonsogp.nhl_app.features.standings.presentation.adapter

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.svg.GlideApp
import com.alonsogp.nhl_app.app.extensions.svg.SvgSoftwareLayerSetter
import com.alonsogp.nhl_app.databinding.ViewItemStandingBinding
import com.alonsogp.nhl_app.features.standings.domain.TeamRecordsModel
import com.bumptech.glide.RequestBuilder

class StandingsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var requestBuilder: RequestBuilder<PictureDrawable>? = null
    private var imageViewNet: ImageView? = null

    fun bind(record: TeamRecordsModel, position: Int) {
        val binding = ViewItemStandingBinding.bind(view)
        val position = position + 1

        imageViewNet = binding.teamLogo

        requestBuilder = GlideApp.with(binding.root.context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())

        loadNet("https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/${record.team.id}.svg")

        binding.standingPosition.text = position.toString()
        binding.teamName.text = record.team.name
        binding.standingWins.text = record.leagueRecord.wins.toString()
        binding.standingLosses.text = record.leagueRecord.losses.toString()
        binding.standingOvertime.text = record.leagueRecord.ot.toString()
        binding.standingPoints.text = record.points.toString()
    }

    private fun loadNet(url: String) {
        val uri: Uri = Uri.parse(url)
        if (imageViewNet != null) {
            requestBuilder?.load(uri)?.into(imageViewNet!!)
        }
    }
}