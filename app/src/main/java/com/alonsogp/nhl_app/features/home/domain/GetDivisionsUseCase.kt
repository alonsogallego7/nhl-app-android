package com.alonsogp.nhl_app.features.home.domain

import android.util.Log
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class GetDivisionsUseCase @Inject constructor(private val divisionsRepository: DivisionsRepository) {
    suspend operator fun invoke(conferenceId: Int): Either<ErrorApp, List<DivisionModel>> {
        val divisions = divisionsRepository.getByConference(conferenceId)
        Log.d("@dev", "Divisions: $divisions")
        return divisions
    }
}