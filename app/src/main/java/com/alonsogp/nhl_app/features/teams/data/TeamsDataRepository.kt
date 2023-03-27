package com.alonsogp.nhl_app.features.teams.data

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.data.remote.api.TeamsApiRemoteSource
import com.alonsogp.nhl_app.features.teams.domain.*
import javax.inject.Inject

class TeamsDataRepository @Inject constructor(
    private val remoteDataSource: TeamsApiRemoteSource
): TeamsRepository {

    override suspend fun getConferences(): Either<ErrorApp, ConferenceListModel> {
        return remoteDataSource.getConferences()
    }

    override suspend fun getDivisionsByConference(conference: Int): Either<ErrorApp, DivisionListModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamsByDivision(division: Int): Either<ErrorApp, TeamListModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailListModel> {
        return remoteDataSource.getTeamById(id)
    }
}