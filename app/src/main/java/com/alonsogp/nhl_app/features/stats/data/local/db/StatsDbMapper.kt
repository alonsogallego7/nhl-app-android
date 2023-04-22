package com.alonsogp.nhl_app.features.stats.data.local.db

import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel

fun TeamStatsModel.toEntity(): TeamStatsEntity = TeamStatsEntity(
    this.id,
    this.name,
    this.goalsPerGame,
    this.shotsPerGame,
    this.shootingPctg
)