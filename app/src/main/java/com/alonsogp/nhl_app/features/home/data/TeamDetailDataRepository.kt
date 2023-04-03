package com.alonsogp.nhl_app.features.home.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailRepository
import javax.inject.Inject

class TeamDetailDataRepository @Inject constructor(
    private val localDataSource: TeamDetailLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : TeamDetailRepository {

    override suspend fun getById(teamId: Int): Either<ErrorApp, TeamDetailModel> {
        val teamLocal = localDataSource.getById(teamId)

        return if (teamLocal.isLeft()) {
            remoteDataSource.getTeamById(teamId).map { teamRemoteList ->
                localDataSource.save(teamRemoteList.first(), teamRemoteList.first().players)
            }
            val teamLocal = localDataSource.getById(teamId)
            teamLocal
        } else {
            teamLocal
        }
    }
}
