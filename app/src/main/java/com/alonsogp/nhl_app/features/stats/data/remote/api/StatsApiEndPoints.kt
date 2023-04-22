package com.alonsogp.nhl_app.features.stats.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StatsApiEndPoints {

    @GET("teams?expand=team.stats")
    suspend fun getStats(): Response<TeamsResponseApiModel>
}