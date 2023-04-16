package com.alonsogp.nhl_app.features.standings.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogp.nhl_app.databinding.ViewItemStandingBinding
import com.alonsogp.nhl_app.features.standings.domain.RecordModel

class StandingsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(record: RecordModel) {
        val binding = ViewItemStandingBinding.bind(view)


    }
}