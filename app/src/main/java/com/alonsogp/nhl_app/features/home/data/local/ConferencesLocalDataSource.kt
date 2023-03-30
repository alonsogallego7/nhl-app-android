package com.alonsogp.nhl_app.features.home.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.ConferenceModel

interface ConferencesLocalDataSource {
    suspend fun getAll(): Either<ErrorApp, List<ConferenceModel>>
    suspend fun save(conferences: List<ConferenceModel>): Either<ErrorApp, Boolean>
}