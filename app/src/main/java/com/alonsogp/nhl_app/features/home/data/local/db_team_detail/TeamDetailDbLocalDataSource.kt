package com.alonsogp.nhl_app.features.home.data.local.db_team_detail

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.domain.PlayerModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel
import javax.inject.Inject

class TeamDetailDbLocalDataSource @Inject constructor(private val teamDetailDao: TeamDetailDao) :
    TeamDetailLocalDataSource {

    override suspend fun getById(teamId: Int): Either<ErrorApp, TeamDetailModel> {
        return try {
            val team = teamDetailDao.getTeamDetailById(teamId)
            val players = teamDetailDao.getPlayersById(teamId)
            return team.toDomain(players).right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun save(team: TeamDetailModel, players: List<PlayerModel>): Either<ErrorApp, Boolean> {
        return try {
            teamDetailDao.saveTeam(team.toEntity())
            teamDetailDao.savePlayers(players.map { it.toEntity() })
            true.right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }
}