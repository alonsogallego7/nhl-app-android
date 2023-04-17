package com.alonsogp.nhl_app.features.standings.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.features.standings.domain.TeamRecordsModel

class StandingsAdapter : RecyclerView.Adapter<StandingsViewHolder>() {

    private val dataItems = mutableListOf<TeamRecordsModel>()

    fun setDataItems(records: List<TeamRecordsModel>) {
        dataItems.clear()
        dataItems.addAll(records)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_standing, parent, false)
        return StandingsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        holder.bind(dataItems[position], position)
    }

    override fun getItemCount(): Int = dataItems.size
}