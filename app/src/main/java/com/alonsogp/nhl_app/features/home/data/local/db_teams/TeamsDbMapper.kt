package com.alonsogp.nhl_app.features.home.data.local.db_teams

import com.alonsogp.nhl_app.features.home.domain.TeamModel

fun TeamEntity.toDomain() = TeamModel(
    this.id,
    this.name,
    this.abbreviation,
    this.logoUrl,
    this.divisionId
)

fun TeamModel.toEntity() = TeamEntity(
    this.id,
    this.name,
    this.abbreviation,
    this.logoUrl,
    this.divisionId
)
