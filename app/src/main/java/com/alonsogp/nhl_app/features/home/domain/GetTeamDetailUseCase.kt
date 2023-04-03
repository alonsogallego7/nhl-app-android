package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetTeamDetailUseCase @Inject constructor(private val teamDetailRepository: TeamDetailRepository) {
    suspend operator fun invoke(teamId: Int): Either<ErrorApp, TeamDetailWithRosterModel> {
        return teamDetailRepository.getById(teamId)
    }
}
