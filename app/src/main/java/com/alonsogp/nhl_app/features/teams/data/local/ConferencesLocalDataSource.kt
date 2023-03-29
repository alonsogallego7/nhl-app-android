package com.alonsogp.nhl_app.features.teams.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.domain.ConferenceModel

interface ConferencesLocalDataSource {
    suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>>
    suspend fun saveConferences(conferences: List<ConferenceModel>): Either<ErrorApp, Boolean>
}