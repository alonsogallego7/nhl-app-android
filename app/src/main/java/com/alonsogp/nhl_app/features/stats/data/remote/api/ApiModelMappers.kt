package com.alonsogp.nhl_app.features.stats.data.remote.api

import com.alonsogp.nhl_app.features.stats.domain.*

fun TeamApiModel.toDomain(): TeamModel = TeamModel(
    this.id,
    this.name,
    this.roster.toDomain()
)

fun RosterApiModel.toDomain(): RosterModel = RosterModel(
    this.roster.map {
        it.toDomain()
    }
)

fun PlayerApiModel.toDomain(): PlayerModel = PlayerModel(
    this.person.toDomain()
)

fun PersonApiModel.toDomain(): PersonModel = PersonModel(
    this.id,
    this.fullName
)

fun PlayerStatsApiModel.toDomain(): PlayerStatsModel = PlayerStatsModel(
    this.goals,
    this.assists,
    this.points
)




