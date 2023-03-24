package com.alonsogp.nhl_app.features.teams.data.remote.api

import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import javax.inject.Inject

class TeamsApiRemoteSource @Inject constructor(private val apiClient: TeamsApiEndPoints){
    override suspend fun getTeams(): Either<ErrorApp, List<TeamApiModel>> {
        return apiCall {
            apiClient.getTeams()
        }.map { teams ->
            teams.map { team ->
                team.toDomain()
            }
        }
    }

    /*
    override suspend fun getById(id: Int): Either<ErrorApp, Animal> {
        return apiCall {
            apiClient.getAnimalById(id)
        }.map { animalApiModel ->
            animalApiModel.toDomain()
        }
    }
     */
}