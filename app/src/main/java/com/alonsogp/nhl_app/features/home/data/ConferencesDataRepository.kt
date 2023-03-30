package com.alonsogp.nhl_app.features.home.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.home.data.local.ConferencesLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.ConferenceModel
import com.alonsogp.nhl_app.features.home.domain.ConferencesRepository
import javax.inject.Inject

class ConferencesDataRepository @Inject constructor(
    private val localDataSource: ConferencesLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : ConferencesRepository {

    override suspend fun getAll(): Either<ErrorApp, List<ConferenceModel>> {
        val conferencesLocal = localDataSource.getAll()

        return if (conferencesLocal.isLeft() || conferencesLocal.get().isEmpty()) {
            remoteDataSource.getConferences().map { conferencesRemote ->
                localDataSource.save(conferencesRemote)
                conferencesRemote
            }
        } else {
            conferencesLocal
        }
    }
}