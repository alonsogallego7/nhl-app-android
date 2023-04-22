package com.alonsogp.nhl_app.features.stats.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetShootingPctgUseCase @Inject constructor(private val statsRepository: StatsRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<TeamOneStatModel>> {
        return statsRepository.getShootingPctg()
    }
}