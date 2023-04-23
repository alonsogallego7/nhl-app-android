package com.alonsogp.nhl_app.features.home.data.remote.api

import android.util.Log
import com.alonsogp.nhl_app.app.data.remote.apiCall
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.flatMap
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.domain.*
import javax.inject.Inject

class HomeApiRemoteSource @Inject constructor(private val apiClient: HomeApiEndPoints) :
    HomeRemoteDataSource {

    override suspend fun getConferences(): Either<ErrorApp, List<ConferenceModel>> {
        return apiCall {
            apiClient.getConferences()
        }.map {
            it.conferences.map { it.toDomain() }
        }
    }

    override suspend fun getDivisions(): Either<ErrorApp, List<DivisionModel>> {
        return apiCall {
            apiClient.getDivisions()
        }.map {
            it.divisions.map { it.toDomain() }
        }
    }

    override suspend fun getTeams(): Either<ErrorApp, List<TeamModel>> {
        return apiCall {
            apiClient.getTeams()
        }.map {
            it.teams.map { it.toDomain("https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/${it.id}.svg") }
        }
    }

    override suspend fun getTeamById(id: Int): Either<ErrorApp, TeamDetailModel> {
        return apiCall {
            apiClient.getTeamById(id)
        }.map {
            it.team.first().toDomain()
        }
    }

    override suspend fun getPlayersByTeam(id: Int): Either<ErrorApp, List<PlayerModel>> {
        return apiCall {
            apiClient.getPlayersByTeam(id)
        }.map {
            it.roster.map {
                it.toDomain()
            }
        }
    }
}