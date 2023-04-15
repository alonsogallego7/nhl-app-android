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

        binding.playerName.text = player.person.fullName
        binding.playerPosition.text = player.position.type
        binding.playerNumber.text = player.jerseyNumber
    }
}