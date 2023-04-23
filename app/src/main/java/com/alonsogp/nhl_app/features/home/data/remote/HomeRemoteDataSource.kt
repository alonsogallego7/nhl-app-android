package com.alonsogp.nhl_app.features.home.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.*

interface HomeRemoteDataSource {
    suspend fun getTeams(): Either<ErrorApp, List<TeamModel>>
    suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailModel>
    suspend fun getPlayersByTeam(id: Int): Either<ErrorApp, List<PlayerModel>>
}