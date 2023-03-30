package com.alonsogp.nhl_app.features.home.data

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.data.local.DivisionsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import com.alonsogp.nhl_app.features.home.domain.DivisionsRepository
import javax.inject.Inject

class DivisionsDataRepository @Inject constructor(
    private val localDataSource: DivisionsLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : DivisionsRepository {

    override suspend fun getByConference(conferenceId: Int): Either<ErrorApp, List<DivisionModel>> {
        val divisionsLocal = localDataSource.getByConference(conferenceId)

        return if (divisionsLocal.isLeft() || divisionsLocal.get().isEmpty()) {
            remoteDataSource.getDivisions().map { divisionsRemote ->
                localDataSource.save(divisionsRemote)
            }
            val divisionsLocal = localDataSource.getByConference(conferenceId)
            divisionsLocal
        } else {
            divisionsLocal
        }
    }
}