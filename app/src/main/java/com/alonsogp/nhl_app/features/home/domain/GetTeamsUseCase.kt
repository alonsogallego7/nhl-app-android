package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(private val teamsRepository: TeamsRepository) {
    suspend operator fun invoke(divisionId: Int): Either<ErrorApp, List<TeamModel>> {
        return teamsRepository.getByDivision(divisionId)
    }
}