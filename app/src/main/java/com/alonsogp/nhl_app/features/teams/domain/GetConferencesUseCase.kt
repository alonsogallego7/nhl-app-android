package com.alonsogp.nhl_app.features.teams.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetConferencesUseCase @Inject constructor(private val teamsRepository: TeamsRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<ConferenceListModel>> {
        return teamsRepository.getConferences().map {
            it.map { conferences ->
                ConferenceListModel(
                    conferences.conferences,
                )
            }
        }
    }
}