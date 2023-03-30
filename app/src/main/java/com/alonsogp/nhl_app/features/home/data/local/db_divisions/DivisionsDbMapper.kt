package com.alonsogp.nhl_app.features.home.data.local.db_divisions

import com.alonsogp.nhl_app.features.home.domain.DivisionModel

fun DivisionEntity.toDomain() = DivisionModel(
    this.id,
    this.name,
    this.conferenceId
)

fun DivisionModel.toEntity() = DivisionEntity(
    this.id,
    this.name,
    this.conferenceId
)