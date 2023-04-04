package com.alonsogp.nhl_app.features.home.data

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.flatMap
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.domain.PlayerModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailRepository
import com.alonsogp.nhl_app.features.home.domain.TeamDetailWithRosterModel
import javax.inject.Inject

class TeamDetailDataRepository @Inject constructor(
    private val localDataSource: TeamDetailLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : TeamDetailRepository {

    override suspend fun getById(teamId: Int): Either<ErrorApp, TeamDetailWithRosterModel> {

        val teamWithRoasterLocal = localDataSource.getById(teamId)

        if (teamWithRoasterLocal.isLeft() || teamWithRoasterLocal == null) {
            return remoteDataSource.getTeamById(teamId).flatMap { remoteTeamDetail ->
                remoteDataSource.getPlayersByTeam(teamId).map { remotePlayerList ->
                    val teamDetailWithRoster = TeamDetailWithRosterModel(
                        remoteTeamDetail.id,
                        remoteTeamDetail.name,
                        remoteTeamDetail.venue,
                        remoteTeamDetail.abbreviation,
                        remoteTeamDetail.firstYearOfPlay,
                        remotePlayerList
                    )
                    localDataSource.save(remoteTeamDetail, remotePlayerList)
                    teamDetailWithRoster
                }
            }
        } else {
            return teamWithRoasterLocal
        }
    }
}
