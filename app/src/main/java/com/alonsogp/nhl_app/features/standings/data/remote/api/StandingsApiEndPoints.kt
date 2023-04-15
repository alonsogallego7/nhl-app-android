package com.alonsogp.nhl_app.features.standings.data.remote.api

import retrofit2.http.GET

interface StandingsApiEndPoints {

    @GET("standings/{id}")
    suspend fun getStandings(id: Int):
}