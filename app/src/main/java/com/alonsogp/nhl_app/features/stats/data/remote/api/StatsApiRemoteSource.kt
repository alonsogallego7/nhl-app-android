package com.alonsogp.nhl_app.features.stats.data.remote.api

import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel
import javax.inject.Inject

class StatsApiRemoteSource @Inject constructor(private val apiClient: StatsApiEndPoints) :
    StatsRemoteDataSource {

    override suspend fun getStats(): Either<ErrorApp, List<TeamStatsModel>> {
        return apiCall {
            apiClient.getStats()
        }.map {
            it.teams.map { team ->
                TeamStatsModel(
                    team.id,
                    team.name,
                    team.teamStats.first().splits.first().stat.goalsPerGame,
                    team.teamStats.first().splits.first().stat.shotsPerGame,
                    team.teamStats.first().splits.first().stat.shootingPctg
                )
            }
        }
    }
}