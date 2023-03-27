package com.alonsogp.nhl_app.features.teams.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.domain.*

interface TeamsRemoteDataSource {
    suspend fun getConferences(): Either<ErrorApp, ConferenceListModel>
    suspend fun getDivisions(): Either<ErrorApp, DivisionListModel>
    suspend fun getTeams(): Either<ErrorApp, TeamListModel>
    suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailListModel>
}