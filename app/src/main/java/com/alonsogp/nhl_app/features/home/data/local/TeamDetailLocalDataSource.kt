package com.alonsogp.nhl_app.features.home.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.PlayerModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel

interface TeamDetailLocalDataSource {
    suspend fun getById(teamId: Int): Either<ErrorApp, TeamDetailModel>
    suspend fun save(team: TeamDetailModel, players: List<PlayerModel>): Either<ErrorApp, Boolean>
}