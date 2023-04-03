package com.alonsogp.nhl_app.features.home.data.remote.api

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
    @SerializedName("teams") val team: List<TeamDetailApiModel>
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
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("venue") val venue: VenueApiModel,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("firstYearOfPlay") val first_year: String,
    @SerializedName("roster") val roster: RosterApiModel
)

data class VenueApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("city") val city: String
)

data class RosterApiModel(
    @SerializedName("roster") val players: List<PlayerApiModel>
)

data class PlayerApiModel(
    @SerializedName("person") val person: PersonApiModel,
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