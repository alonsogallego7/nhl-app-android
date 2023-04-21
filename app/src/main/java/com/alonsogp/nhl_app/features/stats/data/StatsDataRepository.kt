package com.alonsogp.nhl_app.features.stats.data

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.domain.PlayerWithStats
import com.alonsogp.nhl_app.features.stats.domain.StatsRepository
import javax.inject.Inject

class StatsDataRepository @Inject constructor(
    private val remoteDataSource: StatsRemoteDataSource
) : StatsRepository {

    override suspend fun getAll(): Either<ErrorApp, List<PlayerWithStats>> {
        val players = remoteDataSource.getPlayers().map {
            it.flatMap { team ->
                team.roster.roster.map {
                    Player(
                        it.person.id,
                        it.person.fullName,
                        team.id,
                        team.name
                    )
                }
            }
        }

        val playerWithStats = players.map {
            it.flatMap {player ->
                remoteDataSource.getStatsByPlayer(player.id).map {
                    PlayerWithStats(
                        player.id,
                        player.fullName,
                        player.teamId,
                        player.teamName,
                        it.goals,
                        it.assists,
                        it.points,
                    )
                }
            }
        }
        return playerWithStats
    }

    data class Player(
        val id: Int,
        val fullName: String,
        val teamId: Int,
        val teamName: String
    )
}

