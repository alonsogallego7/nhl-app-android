package com.alonsogp.nhl_app.features.teams.data.local.db_conferences

import com.alonsogp.nhl_app.features.teams.domain.ConferenceModel

fun ConferencesEntity.toDomain() = ConferenceModel(
    this.id,
    this.name
)

fun ConferenceModel.toEntity() = ConferencesEntity(
    this.id,
    this.name
)