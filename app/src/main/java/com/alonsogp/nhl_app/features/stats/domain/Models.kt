package com.alonsogp.nhl_app.features.stats.domain

data class TeamModel(
    val id: Int,
    val name: String,
    val roster: RosterModel
)

data class RosterModel(
    val roster: List<PlayerModel>
)

data class PlayerModel(
    val person: PersonModel,
)

data class PersonModel(
    val id: Int,
    val fullName: String
)

data class PlayerStatsModel(
    val goals: Int,
    val assists: Int,
    val points: Int
)

data class PlayerWithStats(
    val playerId: Int,
    val playerName: String,
    val teamId: Int,
    val teamName: String,
    val goals: Int,
    val assists: Int,
    val points: Int
)