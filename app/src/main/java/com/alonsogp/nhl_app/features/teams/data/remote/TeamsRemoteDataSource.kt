package com.alonsogp.nhl_app.features.teams.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.domain.ConferenceModel
import com.alonsogp.nhl_app.features.teams.domain.DivisionModel
import com.alonsogp.nhl_app.features.teams.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.teams.domain.TeamModel

interface TeamsRemoteDataSource {
    suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>>
    suspend fun getDivisions(): Either<ErrorApp, List<DivisionModel>>
    suspend fun getTeams(): Either<ErrorApp, List<TeamModel>>
    suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailModel>
}