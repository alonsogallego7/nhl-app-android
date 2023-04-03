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

fun TeamApiModel.toDomain(): TeamModel = TeamModel(
    this.id,
    this.name,
    this.abbreviation,
    "https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/3.svg",
    this.division.id
)

fun TeamDetailApiModel.toDomain(): TeamDetailModel = TeamDetailModel(
    this.id,
    this.name,
    this.venue.toDomain(),
    this.abbreviation,
    this.first_year,
    this.roster.toDomain()
)

fun RosterApiModel?.toDomain(): List<PlayerModel> {
    return this?.players?.map { it.toDomain() } ?: emptyList()
}

fun VenueApiModel.toDomain(): VenueModel = VenueModel(
    this.name,
    this.city
)

fun PlayerApiModel.toDomain(): PlayerModel = PlayerModel(
    this.person.toDomain(),
    this.jerseyNumber,
    this.position.toDomain(),
    this.teamId
)

fun PersonApiModel.toDomain(): PersonModel = PersonModel(
    this.id,
    this.fullName
)

fun PositionApiModel.toDomain(): PositionModel = PositionModel(
    this.name,
    this.type
)

