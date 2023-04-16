package com.alonsogp.nhl_app.features.standings.data.remote.api

import com.alonsogp.nhl_app.features.home.data.remote.api.ConferenceApiModel

data class StandingsResponseApiModel(
    val records: List<RecordApiModel>
)

data class RecordApiModel(
    val team: TeamApiModel,
    val conference: ConferenceApiModel?,
    val teamRecords: List<TeamRecordsApiModel>
)

data class TeamRecordsApiModel(
    val leagueRecord: LeagueRecordApiModel,
    val points: Int,
)

data class LeagueRecordApiModel(
    val losses: Int,
    val ot: Int,
    val wins: Int
)

data class TeamApiModel(
    val id: Int,
    val name: String
)

