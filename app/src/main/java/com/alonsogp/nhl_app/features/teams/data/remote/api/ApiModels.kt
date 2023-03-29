package com.alonsogp.nhl_app.features.teams.data.remote.api

import com.google.gson.annotations.SerializedName

data class ConferenceListApiModel(
    @SerializedName("conferences") val conferences: List<ConferenceApiModel>
)

data class DivisionListApiModel(
    @SerializedName("divisions") val divisions: List<DivisionApiModel>
)

data class TeamListApiModel(
    @SerializedName("teams") val teams: List<TeamApiModel>
)

data class TeamDetailListApiModel(
    @SerializedName("team") val team: List<TeamDetailApiModel>
)

data class ConferenceApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class DivisionApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("conference") val conference: ConferenceApiModel
)

data class TeamApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("division") val division: DivisionApiModel
)

data class TeamDetailApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("venue") val venue: VenueApiModel,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("firstYearOfPlay") val first_year: String,
    @SerializedName("division") val division: DivisionApiModel,
    @SerializedName("roster") val roster: RosterApiModel
)

data class VenueApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("city") val city: String
)

data class RosterApiModel(
    @SerializedName("roster") val roster: List<PlayerApiModel>
)

data class PlayerApiModel(
    @SerializedName("person") val personal_info: PersonApiModel,
    @SerializedName("jerseyNumber") val jerseyNumber: String,
    @SerializedName("position") val position: PositionApiModel
)

data class PersonApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("fullName") val fullName: String,
)

data class PositionApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)