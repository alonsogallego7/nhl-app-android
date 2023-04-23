package com.alonsogp.nhl_app.features.home.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.data.local.TeamsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import com.alonsogp.nhl_app.features.home.domain.TeamsRepository
import javax.inject.Inject

class TeamsDataRepository @Inject constructor(
    private val localDataSource: TeamsLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : TeamsRepository {
    override suspend fun getByDivision(divisionId: Int): Either<ErrorApp, List<TeamModel>> {
        val teamsLocal = localDataSource.getByDivision(divisionId)

        return if (teamsLocal.isLeft() || teamsLocal.get().isEmpty()) {
            remoteDataSource.getTeams().map { teamsRemote ->
                localDataSource.save(teamsRemote)
            }
            val teamsLocal = localDataSource.getByDivision(divisionId)
            teamsLocal
        } else {
            teamsLocal
        }
    }
}