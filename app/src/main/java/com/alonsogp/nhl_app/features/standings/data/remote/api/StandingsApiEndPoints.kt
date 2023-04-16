package com.alonsogp.nhl_app.features.standings.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StandingsApiEndPoints {

    @GET("standings/{type}.json")
    suspend fun getStandingsByType(@Path("type") type: String): Response<StandingsResponseApiModel>
}