package com.alonsogp.nhl_app.features.stats.data.local.db

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.db_teams.toDomain
import com.alonsogp.nhl_app.features.home.data.local.db_teams.toEntity
import com.alonsogp.nhl_app.features.home.domain.TeamModel
import com.alonsogp.nhl_app.features.stats.data.local.StatsLocalDataSource
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel
import javax.inject.Inject

class StatsDbLocalDataSource @Inject constructor(private val statsDao: StatsDao) :
    StatsLocalDataSource {
    override suspend fun getGoalsPerGame(): Either<ErrorApp, List<TeamOneStatModel>> {
        return try {
            val teams = statsDao.getGoalsPerGame()

            if (teams.isEmpty()) {
                emptyList<TeamOneStatModel>().right()
            } else {
                teams.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun getShotsPerGame(): Either<ErrorApp, List<TeamOneStatModel>> {
        return try {
            val teams = statsDao.getShotsPerGame()

            if (teams.isEmpty()) {
                emptyList<TeamOneStatModel>().right()
            } else {
                teams.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun getShootingPctg(): Either<ErrorApp, List<TeamOneStatModel>> {
        return try {
            val teams = statsDao.getShootingPctg()

            if (teams.isEmpty()) {
                emptyList<TeamOneStatModel>().right()
            } else {
                teams.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun saveStats(teams: List<TeamStatsModel>): Either<ErrorApp, Boolean> {
        return try {
            teams.forEach {
                statsDao.save(it.toEntity())
            }
            true.right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }
}