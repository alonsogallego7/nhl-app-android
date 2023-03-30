package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface TeamsRepository {
    suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>>
    suspend fun getDivisionsByConference(conference: Int): Either<ErrorApp, List<DivisionModel>>
    suspend fun getTeamsByDivision(division: Int): Either<ErrorApp, List<TeamModel>>
    suspend fun getTeamById(id: Int): Either<ErrorApp, List<TeamDetailModel>>
}