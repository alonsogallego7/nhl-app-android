package com.alonsogp.nhl_app.features.home.domain

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either

interface DivisionsRepository {
    suspend fun getByConference(conferenceId: Int): Either<ErrorApp, List<DivisionModel>>
}