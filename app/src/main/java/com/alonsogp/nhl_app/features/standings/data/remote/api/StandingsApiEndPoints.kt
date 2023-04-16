package com.alonsogp.nhl_app.features.standings.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface StandingsApiEndPoints {

    @GET("standings/{type}")
    suspend fun getStandingsByType(type: String): Response<StandingsResponseApiModel>
}