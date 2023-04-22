package com.alonsogp.nhl_app.features.stats.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel

interface StatsLocalDataSource {
    suspend fun getGoalsPerGame(): Either<ErrorApp, List<TeamOneStatModel>>
    suspend fun getShotsPerGame(): Either<ErrorApp, List<TeamOneStatModel>>
    suspend fun getShootingPctg(): Either<ErrorApp, List<TeamOneStatModel>>
    suspend fun saveStats(teams: List<TeamStatsModel>): Either<ErrorApp, Boolean>
}