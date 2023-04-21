package com.alonsogp.nhl_app.features.stats.data.remote.api

data class PlayersResponseApiModel(
    val teams: List<TeamApiModel>
)

data class TeamApiModel(
    val id: Int,
    val name: String,
    val roster: RosterApiModel
)

data class RosterApiModel(
    val roster: List<PlayerApiModel>
)

data class PlayerApiModel(
    val person: PersonApiModel
)

data class PersonApiModel(
    val id: Int,
    val fullName: String
)

data class PlayerStatsResponseApiModel(
    val stats: List<StatsResponseApiModel>
)

data class StatsResponseApiModel(
    val splits: List<SplitsResponseApiModel>
)

data class SplitsResponseApiModel(
    val stat: PlayerStatsApiModel
)

data class PlayerStatsApiModel(
    val goals: Int,
    val assists: Int,
    val points: Int
)