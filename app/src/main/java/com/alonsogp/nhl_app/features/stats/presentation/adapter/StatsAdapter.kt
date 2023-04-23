package com.alonsogp.nhl_app.features.stats.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel

class StatsAdapter : RecyclerView.Adapter<StatsViewHolder>() {

    private val dataItems = mutableListOf<TeamOneStatModel>()

    fun setDataItems(teams: List<TeamOneStatModel>) {
        dataItems.clear()
        dataItems.addAll(teams)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_stats, parent, false)
        return StatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(dataItems[position], position)
    }

    override fun getItemCount(): Int = dataItems.size
}