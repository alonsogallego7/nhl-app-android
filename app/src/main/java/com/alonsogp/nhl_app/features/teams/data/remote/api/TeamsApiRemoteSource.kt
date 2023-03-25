package com.alonsogp.nhl_app.features.teams.data.remote.api

import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.data.remote.TeamsRemoteDataSource
import com.alonsogp.nhl_app.features.teams.domain.ConferenceModel
import com.alonsogp.nhl_app.features.teams.domain.DivisionModel
import com.alonsogp.nhl_app.features.teams.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.teams.domain.TeamModel
import javax.inject.Inject

class TeamsApiRemoteSource @Inject constructor(private val apiClient: TeamsApiEndPoints): TeamsRemoteDataSource{

    override suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>> {
        return apiCall {
            apiClient.getConferences()
        }.map { conferences ->
            conferences.map { conference ->
                conference.toDomain()
            }
        }
    }

    override suspend fun getDivisions(): Either<ErrorApp, List<DivisionModel>> {
        return apiCall {
            apiClient.getDivisions()
        }.map { divisions ->
            divisions.map { division ->
                division.toDomain()
            }
        }
    }

    override suspend fun getTeams(): Either<ErrorApp, List<TeamModel>> {
        return apiCall {
            apiClient.getTeams()
        }.map { teams ->
            teams.map { team ->
                team.toDomain()
            }
        }
    }

    override suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailModel> {
        return apiCall {
            apiClient.getTeamById(id)
        }.map { animalApiModel ->
            animalApiModel.toDomain()
        }
    }
}