package com.alonsogp.nhl_app.features.stats.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel

interface StatsRemoteDataSource {
    suspend fun getStats(): Either<ErrorApp, List<TeamStatsModel>>
}