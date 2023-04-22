package com.alonsogp.nhl_app.features.stats.domain

data class TeamStatsModel(
    val id: Int,
    val name: String,
    val goalsPerGame: String,
    val shotsPerGame: String,
    val shootingPctg: String
)

data class TeamOneStatModel(
    val id: Int,
    val name: String,
    val stat: String
)

