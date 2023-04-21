package com.alonsogp.nhl_app.features.stats.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StatsApiEndPoints {

    @GET("teams?expand=team.roster")
    suspend fun getPlayers(): Response<PlayersResponseApiModel>

    @GET("people/{id}/stats?stats=statsSingleSeason")
    suspend fun getStatsByPlayer(@Path("id") id: Int): Response<PlayerStatsResponseApiModel>
}