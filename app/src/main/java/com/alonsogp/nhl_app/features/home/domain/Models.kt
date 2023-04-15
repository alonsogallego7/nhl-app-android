package com.alonsogp.nhl_app.features.home.domain

data class ConferenceModel(
    val id: Int,
    val name: String
)

data class DivisionModel(
    val id: Int,
    val name: String,
    val conferenceId: Int
)

data class TeamModel(
    val id: Int,
    val name: String,
    val abbreviation: String,
    val logoUrl: String,
    val divisionId: Int
)

data class TeamDetailModel(
    val id: Int,
    val name: String,
    val venue: VenueModel,
    val abbreviation: String,
    val firstYearOfPlay: String,
)

data class TeamDetailWithRosterModel(
    val id: Int,
    val name: String,
    val venue: VenueModel,
    val abbreviation: String,
    val firstYearOfPlay: String,
    val roster: List<PlayerModel>
)

data class RosterModel(
    val players: List<PlayerModel>
)

data class VenueModel(
    val name: String,
    val city: String
)

data class PlayerModel(
    val person: PersonModel,
    val jerseyNumber: String,
    val position: PositionModel,
)

data class PersonModel(
    val id: Int,
    val fullName: String,
)

data class PositionModel(
    val name: String,
    val type: String
)