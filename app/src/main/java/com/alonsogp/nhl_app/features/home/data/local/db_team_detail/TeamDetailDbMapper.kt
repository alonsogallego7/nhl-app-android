package com.alonsogp.nhl_app.features.home.data.local.db_team_detail

import com.alonsogp.nhl_app.features.home.data.remote.api.toDomain
import com.alonsogp.nhl_app.features.home.domain.*

// TeamDetailEntity
fun TeamDetailEntity.toDomain(players: List<PlayerEntity>) = TeamDetailWithRosterModel(
    this.id,
    this.name,
    this.venue.toDomain(),
    this.abbreviation,
    this.firstYearOfPlay,
    players.map { it.toDomain() }
)

fun TeamDetailModel.toEntity() = TeamDetailEntity(
    this.id,
    this.name,
    this.venue.toEntity(),
    this.abbreviation,
    this.firstYearOfPlay
)

// VenueEntity
fun VenueEntity.toDomain() = VenueModel(
    this.name,
    this.city
)

fun VenueModel.toEntity() = VenueEntity(
    0,
    this.name,
    this.city
)

// PlayerEntity
fun PlayerEntity.toDomain() = PlayerModel(
    this.person.toDomain(),
    this.jerseyNumber,
    this.position.toDomain()
)

fun PlayerModel.toEntity(teamId: Int) = PlayerEntity(
    this.person.id,
    this.person.toEntity(),
    this.jerseyNumber,
    this.position.toEntity(),
    teamId
)

// PersonEntity
fun PersonEntity.toDomain() = PersonModel(
    this.id,
    this.fullName,
    "http://nhl.bamcontent.com/images/headshots/current/168x168/${this.id}.jpg"
)

fun PersonModel.toEntity() = PersonEntity(
    this.id,
    this.fullName
)

// PositionEntity
fun PositionEntity.toDomain() = PositionModel(
    this.name,
    this.type
)

fun PositionModel.toEntity() = PositionEntity(
    0,
    this.name,
    this.type
)
