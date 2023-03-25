package com.alonsogp.nhl_app.features.teams.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface TeamsRepository {
    suspend fun getConferences(): Either<ErrorApp, List<ConferenceListModel>>
    suspend fun getDivisionsByConference(conference: Int): Either<ErrorApp, List<DivisionListModel>>
    suspend fun getTeamsByDivision(division: Int): Either<ErrorApp, List<TeamListModel>>
    suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailListModel>
}