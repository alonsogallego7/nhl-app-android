package com.alonsogp.nhl_app.features.stats.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface StatsRepository {
    suspend fun getGoalsPerGame(): Either<ErrorApp, List<TeamOneStatModel>>
    suspend fun getShotsPerGame(): Either<ErrorApp, List<TeamOneStatModel>>
    suspend fun getShootingPctg(): Either<ErrorApp, List<TeamOneStatModel>>
}