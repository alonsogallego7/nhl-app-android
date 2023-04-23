package com.alonsogp.nhl_app.features.stats.data.local.db

import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel

fun TeamStatsModel.toEntity(): TeamStatsEntity = TeamStatsEntity(
    this.id,
    this.name,
    this.goalsPerGame,
    this.shotsPerGame,
    this.shootingPctg
)

fun StatGoalsPerGameEntity.toDomain(): TeamOneStatModel = TeamOneStatModel(
    this.id,
    this.name,
    this.goalsPerGame
)

fun StatShotsPerGameEntity.toDomain(): TeamOneStatModel = TeamOneStatModel(
    this.id,
    this.name,
    this.shotsPerGame
)

fun StatShootingPctgEntity.toDomain(): TeamOneStatModel = TeamOneStatModel(
    this.id,
    this.name,
    this.shootingPctg.toString() + "%"
)