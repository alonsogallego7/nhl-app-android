package com.alonsogp.nhl_app.features.stats.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface StatsRepository {
    suspend fun getAll(): Either<ErrorApp, List<PlayerWithStats>>
}