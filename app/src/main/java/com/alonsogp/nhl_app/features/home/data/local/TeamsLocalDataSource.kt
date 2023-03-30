package com.alonsogp.nhl_app.features.home.data.local

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.domain.TeamModel

interface TeamsLocalDataSource {
    suspend fun getByDivision(divisionId: Int): Either<ErrorApp, List<TeamModel>>
    suspend fun save(teams: List<TeamModel>): Either<ErrorApp, Boolean>

}