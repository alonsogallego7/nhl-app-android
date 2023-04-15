package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.features.home.domain.PlayerModel

class PlayersAdapter: RecyclerView.Adapter<PlayersViewHolder>() {

    private val dataItems = mutableListOf<PlayerModel>()

    fun setDataItems(players: List<PlayerModel>) {
        dataItems.clear()
        dataItems.addAll(players)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_players, parent, false)
        return PlayersViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }

    override fun getItemCount(): Int = dataItems.size
}