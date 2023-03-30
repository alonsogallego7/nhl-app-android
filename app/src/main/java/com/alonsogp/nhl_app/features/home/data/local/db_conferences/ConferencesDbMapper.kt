package com.alonsogp.nhl_app.features.home.data.local.db_conferences

import com.alonsogp.nhl_app.features.home.domain.ConferenceModel

fun ConferenceEntity.toDomain() = ConferenceModel(
    this.id,
    this.name
)

fun ConferenceModel.toEntity() = ConferenceEntity(
    this.id,
    this.name
)