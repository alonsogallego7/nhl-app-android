package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.app.extensions.loadUrl
import com.alonsogp.nhl_app.databinding.ViewItemPlayersBinding
import com.alonsogp.nhl_app.features.home.domain.PlayerModel

class PlayersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(player: PlayerModel, itemClick: ((Int) -> Unit)?) {
        val binding = ViewItemPlayersBinding.bind(view)

        Log.d("@dev", "Antes de load")

        binding.playerImage.loadUrl(player.person.faceUrl)

        Log.d("@dev", "Despues de load")
        binding.playerName.text = player.person.fullName
        binding.playerPosition.text = player.position.type
        binding.playerNumber.text = player.jerseyNumber

        view.setOnClickListener {
            itemClick?.invoke(player.person.id)
        }
    }
}