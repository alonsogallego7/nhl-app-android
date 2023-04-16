package com.alonsogp.nhl_app.features.standings.domain

import com.alonsogp.nhl_app.features.home.domain.ConferenceModel

data class RecordModel(
    val conference: ConferenceModel?,
    val teamRecords: List<TeamRecordsModel>
)

data class TeamRecordsModel(
    val team: TeamModel,
    val leagueRecord: LeagueRecordModel,
    val points: Int,
)

data class LeagueRecordModel(
    val losses: Int,
    val ot: Int,
    val wins: Int
)

data class TeamModel(
    val id: Int,
    val name: String
)