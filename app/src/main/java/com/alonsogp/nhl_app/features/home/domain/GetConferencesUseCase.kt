package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetConferencesUseCase @Inject constructor(private val conferencesRepository: ConferencesRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<ConferenceModel>> {
        return conferencesRepository.getAll()
    }
}