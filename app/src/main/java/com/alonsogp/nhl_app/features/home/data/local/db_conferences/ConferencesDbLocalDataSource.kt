package com.alonsogp.nhl_app.features.home.data.local.db_conferences

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.ConferencesLocalDataSource
import com.alonsogp.nhl_app.features.home.domain.ConferenceModel
import javax.inject.Inject

class ConferencesDbLocalDataSource @Inject constructor(private val conferencesDao: ConferencesDao) : ConferencesLocalDataSource {
    override suspend fun getAll(): Either<ErrorApp, List<ConferenceModel>> {
        return try {
            val conferences = conferencesDao.getAll()

            return if (conferences.isEmpty()) {
                emptyList<ConferenceModel>().right()
            } else {
                return conferences.map {
                    it.toDomain()
                }.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun save(conferences: List<ConferenceModel>): Either<ErrorApp, Boolean> {
        return try {
            conferences.map {
                it.toEntity()
            }
            true.right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

}