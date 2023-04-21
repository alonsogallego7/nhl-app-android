package com.alonsogp.nhl_app.features.stats.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.domain.PlayerStatsModel
import com.alonsogp.nhl_app.features.stats.domain.TeamModel

interface StatsRemoteDataSource {
    suspend fun getPlayers(): Either<ErrorApp, List<TeamModel>>
    suspend fun getStatsByPlayer(playerId: Int): List<PlayerStatsModel>
}