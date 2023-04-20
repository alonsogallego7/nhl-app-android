package com.alonsogp.nhl_app.features.stats.domain

data class PlayersStatsModel(
    val playerStats: List<PlayerStatsModel>
)

data class PlayerStatsModel(
    val playerId: Int,
    val goals: Int,
    val assists: Int,
    val points: Int,
    val teamId: Int,
    val teamName: Int
)