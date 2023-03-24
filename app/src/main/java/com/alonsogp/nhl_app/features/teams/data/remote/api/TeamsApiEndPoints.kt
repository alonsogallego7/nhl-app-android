package com.alonsogp.nhl_app.features.teams.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsApiEndPoints {
    @GET("conferences.json")
    suspend fun getConferences() : Response<List<ConferenceApiModel>>

    @GET("divisions.json")
    suspend fun getDivisions() : Response<List<DivisionApiModel>>

    @GET("teams.json")
    suspend fun getTeams() : Response<List<TeamApiModel>>

    @GET("teams/{id}?expand=team.roster.json")
    suspend fun getTeamById(@Path("id") id: Int): Response<TeamDetailApiModel>
}