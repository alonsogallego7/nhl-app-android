package com.alonsogp.nhl_app.features.teams.data.remote.api

import com.alonsogp.nhl_app.features.teams.domain.*

fun ConferenceListApiModel.toDomain(): ConferenceListModel = ConferenceListModel(
    this.conferences.map {
        it.toDomain()
    }
)

fun DivisionListApiModel.toDomain(): DivisionListModel = DivisionListModel(
    this.divisions.map {
        it.toDomain()
    }
)

fun TeamListApiModel.toDomain(): TeamListModel = TeamListModel(
    this.teams.map {
        it.toDomain()
    }
)

fun TeamDetailListApiModel.toDomain(): TeamDetailListModel = TeamDetailListModel(
    this.team.map {
        it.toDomain()
    }
)

fun ConferenceApiModel.toDomain(): ConferenceModel = ConferenceModel(
    this.id,
    this.name
)

fun DivisionApiModel.toDomain(): DivisionModel = DivisionModel(
    this.id,
    this.name,
    this.conference.toDomain()
)

fun TeamApiModel.toDomain(): TeamModel = TeamModel(
    this.id,
    this.name,
    this.abbreviation
)

fun TeamDetailApiModel.toDomain(): TeamDetailModel = TeamDetailModel(
    this.name,
    this.venue.toDomain(),
    this.abbreviation,
    this.first_year,
    this.division.toDomain(),
    this.roster.toDomain()
)

fun VenueApiModel.toDomain(): VenueModel = VenueModel(
    this.name,
    this.city
)

fun RosterApiModel.toDomain(): RosterModel = RosterModel(
    this.roster.map { it.toDomain() }
)

fun PlayerApiModel.toDomain(): PlayerModel = PlayerModel(
    this.personal_info.toDomain(),
    this.jerseyNumber,
    this.position.toDomain()
)

fun PersonApiModel.toDomain(): PersonModel = PersonModel(
    this.id,
    this.fullName
)

fun PositionApiModel.toDomain(): PositionModel = PositionModel(
    this.name,
    this.type
)

