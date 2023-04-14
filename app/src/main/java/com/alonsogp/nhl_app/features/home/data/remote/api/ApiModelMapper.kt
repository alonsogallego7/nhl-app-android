package com.alonsogp.nhl_app.features.home.data.remote.api

import com.alonsogp.nhl_app.features.home.domain.*

fun ConferenceApiModel.toDomain(): ConferenceModel = ConferenceModel(
    this.id,
    this.name
)

fun DivisionApiModel.toDomain(): DivisionModel = DivisionModel(
    this.id,
    this.name,
    this.conference.id
)

fun TeamApiModel.toDomain(logoUrl: String): TeamModel = TeamModel(
    this.id,
    this.name,
    this.abbreviation,
    logoUrl,
    this.division.id
)

fun TeamDetailApiModel.toDomain(): TeamDetailModel = TeamDetailModel(
    this.id,
    this.name,
    this.venue.toDomain(),
    this.abbreviation,
    this.firstYearOfPlay
)

fun RosterApiModel.toDomain(): RosterModel = RosterModel(
    this.roster.map { it.toDomain() }
)

fun VenueApiModel.toDomain(): VenueModel = VenueModel(
    this.name,
    this.city
)

fun PlayerApiModel.toDomain(): PlayerModel = PlayerModel(
    this.person.toDomain(),
    this.jerseyNumber,
    this.position.toDomain()
)

fun PersonApiModel.toDomain(): PersonModel = PersonModel(
    this.id,
    this.fullName,
    "http://nhl.bamcontent.com/images/headshots/current/168x168/${this.id}.jpg"
)

fun PositionApiModel.toDomain(): PositionModel = PositionModel(
    this.name,
    this.type
)

