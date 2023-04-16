package com.alonsogp.nhl_app.features.standings.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.standings.domain.RecordModel

interface StandingsRemoteDataSource {
    suspend fun getStandingsByType(type:String): Either<ErrorApp, List<RecordModel>>
}