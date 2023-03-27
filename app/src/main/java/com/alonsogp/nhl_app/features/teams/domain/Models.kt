package com.alonsogp.nhl_app.features.teams.domain

import com.alonsogp.nhl_app.features.teams.data.remote.api.ConferenceApiModel
import com.alonsogp.nhl_app.features.teams.data.remote.api.DivisionApiModel
import com.alonsogp.nhl_app.features.teams.data.remote.api.TeamApiModel

data class ConferenceListModel(
    val conferences: List<ConferenceModel>
)

data class DivisionListModel(
    val divisions: List<DivisionModel>
)

data class TeamListModel(
    val teams: List<TeamModel>
)

data class TeamDetailListModel(
    val team: List<TeamDetailModel>
)

data class ConferenceModel(
    val id: Int,
    val name: String
)

data class DivisionModel(
    val id: Int,
    val name: String,
    val conference: ConferenceModel
)

data class TeamModel(
    val id: Int,
    val name: String,
    val abbreviation: String
)

data class TeamDetailModel(
    val name: String,
    val venue: VenueModel,
    val abbreviation: String,
    val first_year: String,
    val division: DivisionModel,
    val roster: RosterModel
)

data class VenueModel(
    val name: String,
    val city: String
)

data class RosterModel(
    val roster: List<PlayerModel>
)

data class PlayerModel(
    val personal_info: PersonModel,
    val jerseyNumber: String,
    val position: PositionModel
)

data class PersonModel(
    val id: Int,
    val fullName: String,
)

data class PositionModel(
    val name: String,
    val type: String
)