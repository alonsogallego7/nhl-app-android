package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.loadUrlPlayer
import com.alonsogp.nhl_app.databinding.ViewItemPlayersBinding
import com.alonsogp.nhl_app.features.home.domain.PlayerModel

class PlayersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(player: PlayerModel) {
        val binding = ViewItemPlayersBinding.bind(view)

        binding.playerImage.loadUrlPlayer("https://cms.nhl.bamgrid.com/images/headshots/current/168x168/${player.person.id}@2x.jpg")
        binding.playerName.text = player.person.fullName
        binding.playerPosition.text = player.position.type
        binding.playerNumber.text = player.jerseyNumber
    }
}