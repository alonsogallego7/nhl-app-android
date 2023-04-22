package com.alonsogp.nhl_app.features.stats.data

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.flatMap
import com.alonsogp.nhl_app.features.stats.data.local.StatsLocalDataSource
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.domain.StatsRepository
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import javax.inject.Inject


class StatsDataRepository @Inject constructor(
    private val localDataSource: StatsLocalDataSource,
    private val remoteDataSource: StatsRemoteDataSource
) : StatsRepository {
    override suspend fun getGoalsPerGame(): Either<ErrorApp, List<TeamOneStatModel>> {
        return remoteDataSource.getStats().flatMap {
            Log.d("@dev", "$it")
            localDataSource.saveStats(it)
            localDataSource.getGoalsPerGame()
        }
    }

    override suspend fun getShotsPerGame(): Either<ErrorApp, List<TeamOneStatModel>> {
        return remoteDataSource.getStats().flatMap {
            localDataSource.saveStats(it)
            localDataSource.getShotsPerGame()
        }
    }

    override suspend fun getShootingPctg(): Either<ErrorApp, List<TeamOneStatModel>> {
        return remoteDataSource.getStats().flatMap {
            localDataSource.saveStats(it)
            localDataSource.getShootingPctg()
        }
    }


}

