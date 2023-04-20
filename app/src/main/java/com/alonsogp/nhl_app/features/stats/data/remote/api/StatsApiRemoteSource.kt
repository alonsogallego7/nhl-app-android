package com.alonsogp.nhl_app.features.stats.data.remote.api

import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.domain.PlayersStatsModel
import javax.inject.Inject

class StatsApiRemoteSource @Inject constructor(private val apiClient: StatsApiEndPoints) :
    StatsRemoteDataSource {

    override suspend fun getPlayersStats(): Either<ErrorApp, List<PlayersStatsModel>> {
        apiCall {
            apiClient.getPlayers()
        }.map {
            it.teams.map {
                it.
            }
        }
    }
}