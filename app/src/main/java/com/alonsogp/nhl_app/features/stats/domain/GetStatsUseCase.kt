package com.alonsogp.nhl_app.features.stats.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.standings.domain.RecordModel
import javax.inject.Inject

class GetStatsUseCase @Inject constructor(private val statsRepository: StatsRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<PlayerWithStats>> {
        return statsRepository.getAll()
    }
}