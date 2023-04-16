package com.alonsogp.nhl_app.features.standings.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface StandingsRepository {
    suspend fun getByType(type: String, conferenceId: Int?): Either<ErrorApp, List<RecordModel>>
}