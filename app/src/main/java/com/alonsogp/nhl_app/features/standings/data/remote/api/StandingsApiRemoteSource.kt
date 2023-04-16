package com.alonsogp.nhl_app.features.standings.data.remote.api

import android.util.Log
import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.standings.data.remote.StandingsRemoteDataSource
import com.alonsogp.nhl_app.features.standings.domain.RecordModel
import javax.inject.Inject

class StandingsApiRemoteSource @Inject constructor(private val apiClient: StandingsApiEndPoints) :
    StandingsRemoteDataSource {
    override suspend fun getStandingsByType(type: String): Either<ErrorApp, List<RecordModel>> {
        return apiCall {
            apiClient.getStandingsByType(type)
        }.map {
            it.records.map {
                it.toDomain()
            }
        }
    }
}