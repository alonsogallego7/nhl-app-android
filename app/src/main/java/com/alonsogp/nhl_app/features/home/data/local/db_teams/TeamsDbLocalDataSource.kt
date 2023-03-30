package com.alonsogp.nhl_app.features.home.data.local.db_teams

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.TeamsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_divisions.toEntity
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import javax.inject.Inject

class TeamsDbLocalDataSource @Inject constructor(private val teamsDao: TeamsDao) :
    TeamsLocalDataSource {
    override suspend fun getByDivision(divisionId: Int): Either<ErrorApp, List<TeamModel>> {
        return try {
            val teams = teamsDao.getTeamsByDivision(divisionId)

            if (teams.isEmpty()) {
                emptyList<TeamModel>().right()
            } else {
                teams.map {
                    it.toDomain()
                }.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun save(teams: List<TeamModel>): Either<ErrorApp, Boolean> {
        return try {
            teams.map {
                it.toEntity()
            }
            true.right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }
}
