package com.alonsogp.nhl_app.features.stats.data.remote.api

data class TeamsResponseApiModel(
    val teams: List<TeamApiModel>
)

data class TeamApiModel(
    val id: Int,
    val name: String,
    val teamStats: List<StatsApiModel>
)

data class StatsApiModel(
    val splits: List<SplitsApiModel>
)

data class SplitsApiModel(
    val stat: StatApiModel
)

data class StatApiModel(
    val goalsPerGame: Float,
    val shotsPerGame: Float,
    val shootingPctg: Float
)