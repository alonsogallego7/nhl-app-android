package com.alonsogp.nhl_app.features.home.data.local.db_divisions

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import com.alonsogp.nhl_app.features.home.data.local.DivisionsLocalDataSource
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import javax.inject.Inject

class DivisionsDbLocalDataSource @Inject constructor(private val divisionsDao: DivisionsDao) :
    DivisionsLocalDataSource {
    override suspend fun getByConference(conferenceId: Int): Either<ErrorApp, List<DivisionModel>> {
        return try {
            val divisions = divisionsDao.getDivisionsByConference(conferenceId)

            return if (divisions.isEmpty()) {
                emptyList<DivisionModel>().right()
            } else {
                divisions.map {
                    it.toDomain()
                }.right()
            }
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun save(divisions: List<DivisionModel>): Either<ErrorApp, Boolean> {
        return try {
            divisions.forEach {
                divisionsDao.save(it.toEntity())
                Log.d("@dev", "Saved division: $it")
            }
            true.right()
        } catch (e: Exception) {
            ErrorApp.DataError.left()
        }
    }
}