package com.alonsogp.nhl_app.features.standings.data.remote.api

import com.alonsogp.nhl_app.features.home.data.remote.api.toDomain
import com.alonsogp.nhl_app.features.standings.domain.LeagueRecordModel
import com.alonsogp.nhl_app.features.standings.domain.RecordModel
import com.alonsogp.nhl_app.features.standings.domain.TeamModel
import com.alonsogp.nhl_app.features.standings.domain.TeamRecordsModel

fun RecordApiModel.toDomain(): RecordModel = RecordModel(
    this.conference?.toDomain(),
    this.teamRecords.map { it.toDomain() }
)

fun TeamRecordsApiModel.toDomain(): TeamRecordsModel = TeamRecordsModel(
    this.team.toDomain(),
    this.leagueRecord.toDomain(),
    this.points
)

fun LeagueRecordApiModel.toDomain(): LeagueRecordModel = LeagueRecordModel(
    this.losses,
    this.ot,
    this.wins
)

fun TeamApiModel.toDomain(): TeamModel = TeamModel(
    this.id,
    this.name
)