package com.alonsogp.nhl_app.features.home.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.*
import javax.inject.Inject

class TeamsDataRepository @Inject constructor(
    private val remoteDataSource: HomeApiRemoteSource
): TeamsRepository {

    override suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDivisionsByConference(conference: Int): Either<ErrorApp, List<DivisionModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamsByDivision(division: Int): Either<ErrorApp, List<TeamModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamById(id: Int): Either<ErrorApp, List<TeamDetailModel>> {
        TODO("Not yet implemented")
    }
}