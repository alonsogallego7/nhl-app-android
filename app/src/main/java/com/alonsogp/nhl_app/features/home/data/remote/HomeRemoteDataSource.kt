package com.alonsogp.nhl_app.features.home.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.*

interface HomeRemoteDataSource {
    suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>>
    suspend fun getDivisions(): Either<ErrorApp, List<DivisionModel>>
    suspend fun getTeams(): Either<ErrorApp, List<TeamModel>>
    suspend fun getTeamById(id: Int): Either<ErrorApp, List<TeamDetailModel>>
}