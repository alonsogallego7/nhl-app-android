package com.alonsogp.nhl_app.features.home.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiEndPoints {
    @GET("conferences.json")
    suspend fun getConferences() : Response<ConferenceListApiModel>

    @GET("divisions.json")
    suspend fun getDivisions() : Response<DivisionListApiModel>

    @GET("teams.json")
    suspend fun getTeams() : Response<TeamListApiModel>

    @GET("teams/{id}?expand=team.roster.json")
    suspend fun getTeamById(@Path("id") id: Int): Response<TeamDetailListApiModel>
}