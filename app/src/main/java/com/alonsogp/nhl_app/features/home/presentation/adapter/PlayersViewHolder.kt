package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.loadUrl
import com.alonsogp.nhl_app.databinding.ViewItemPlayersBinding
import com.alonsogp.nhl_app.features.home.domain.PlayerModel
import com.bumptech.glide.Glide

class PlayersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(player: PlayerModel) {
        val binding = ViewItemPlayersBinding.bind(view)

        binding.playerImage.loadUrl("https://cms.nhl.bamgrid.com/images/headshots/current/168x168/${player.person.id}@2x.jpg")
        binding.playerName.text = player.person.fullName
        binding.playerPosition.text = player.position.type
        binding.playerNumber.text = player.jerseyNumber
    }
}