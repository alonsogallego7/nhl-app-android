package com.alonsogp.nhl_app.features.home.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.DivisionModel

interface DivisionsLocalDataSource {
    suspend fun getByConference(conferenceId: Int): Either<ErrorApp, List<DivisionModel>>
    suspend fun save(divisions: List<DivisionModel>): Either<ErrorApp, Boolean>
}