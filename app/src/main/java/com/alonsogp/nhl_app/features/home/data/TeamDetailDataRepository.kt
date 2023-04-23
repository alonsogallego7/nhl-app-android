package com.alonsogp.nhl_app.features.home.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.flatMap
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.domain.TeamDetailRepository
import com.alonsogp.nhl_app.features.home.domain.TeamDetailWithRosterModel
import javax.inject.Inject

class TeamDetailDataRepository @Inject constructor(
    private val localDataSource: TeamDetailLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : TeamDetailRepository {

    override suspend fun getById(teamId: Int): Either<ErrorApp, TeamDetailWithRosterModel> {
        return remoteDataSource.getTeamById(teamId).flatMap { remoteTeamDetail ->
            remoteDataSource.getPlayersByTeam(teamId).flatMap { remotePlayerList ->
                localDataSource.save(remoteTeamDetail, remotePlayerList)
                localDataSource.getById(teamId)
            }
        }
    }
}
