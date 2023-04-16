package com.alonsogp.nhl_app.features.standings.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.standings.data.remote.StandingsRemoteDataSource
import com.alonsogp.nhl_app.features.standings.domain.RecordModel
import com.alonsogp.nhl_app.features.standings.domain.StandingsRepository
import javax.inject.Inject

class StandingsDataRepository @Inject constructor(
    private val remoteDataSource: StandingsRemoteDataSource
) : StandingsRepository {

    override suspend fun getByType(type: String, conferenceId: Int?): Either<ErrorApp, List<RecordModel>> {
        return remoteDataSource.getStandingsByType(type)
    }
}