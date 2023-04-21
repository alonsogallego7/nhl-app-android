package com.alonsogp.nhl_app.features.stats.data.remote.api

import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.domain.PlayerStatsModel
import com.alonsogp.nhl_app.features.stats.domain.TeamModel
import javax.inject.Inject

class StatsApiRemoteSource @Inject constructor(private val apiClient: StatsApiEndPoints) :
    StatsRemoteDataSource {

    override suspend fun getPlayers(): Either<ErrorApp, List<TeamModel>> {
        return apiCall {
            apiClient.getPlayers()
        }.map {
            it.teams.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getStatsByPlayer(playerId: Int): List<PlayerStatsModel> {
        return apiClient.getStatsByPlayer(playerId).body()?.stats?.first()?.splits?.map {
            it.stat.toDomain()
        } ?: emptyList()
    }
}