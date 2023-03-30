package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetDivisionsUseCase @Inject constructor(private val divisionsRepository: DivisionsRepository) {
    suspend operator fun invoke(conferenceId: Int): Either<ErrorApp, List<DivisionModel>> {
        return divisionsRepository.getByConference(conferenceId)
    }
}