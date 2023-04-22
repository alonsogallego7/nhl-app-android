package com.alonsogp.nhl_app.features.stats.domain

data class TeamStatsModel(
    val id: Int,
    val name: String,
    val goalsPerGame: Float,
    val shotsPerGame: Float,
    val shootingPctg: Float
)

data class TeamOneStatModel(
    val id: Int,
    val name: String,
    val stat: Float
)

