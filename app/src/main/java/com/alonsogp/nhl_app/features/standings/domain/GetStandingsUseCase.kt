package com.alonsogp.nhl_app.features.standings.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetStandingsUseCase @Inject constructor(private val standingsRepository: StandingsRepository) {
    suspend operator fun invoke(type: String, conferenceId: Int?): Either<ErrorApp, List<RecordModel>> {
        return standingsRepository.getByType(type, conferenceId)
    }
}