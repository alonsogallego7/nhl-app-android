package com.alonsogp.nhl_app.features.teams.data.remote.api

import android.util.Log
import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.teams.data.remote.TeamsRemoteDataSource
import com.alonsogp.nhl_app.features.teams.domain.*
import javax.inject.Inject

class TeamsApiRemoteSource @Inject constructor(private val apiClient: TeamsApiEndPoints) :
    TeamsRemoteDataSource {

    override suspend fun getConferences(): Either<ErrorApp, ConferenceListModel> {
        return apiCall {
            apiClient.getConferences()
        }.map { conferences ->
            conferences.toDomain()
        }
    }

    override suspend fun getDivisions(): Either<ErrorApp, DivisionListModel> {
        return apiCall {
            apiClient.getDivisions()
        }.map { divisions ->
            divisions.toDomain()
        }
    }

    override suspend fun getTeams(): Either<ErrorApp, TeamListModel> {
        return apiCall {
            apiClient.getTeams()
        }.map { teams ->
            teams.toDomain()
        }
    }

    override suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailListModel> {
        return apiCall {
            apiClient.getTeamById(id)
        }.map { team ->
            team.toDomain()
        }
    }
}