package com.alonsogp.nhl_app.features.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.features.home.domain.TeamModel

class TeamsAdapter : RecyclerView.Adapter<TeamsViewHolder>() {

    private val dataItems = mutableListOf<TeamModel>()
    private var itemClick: ((Int) -> Unit)? = null

    fun setOnClickItem(itemClick: (Int) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(teams: List<TeamModel>) {
        dataItems.clear()
        dataItems.addAll(teams)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_teams, parent, false)
        return TeamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount(): Int = dataItems.size
}