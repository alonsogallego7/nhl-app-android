package com.alonsogp.nhl_app.features.stats.data.local.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.TABLE_NAME_PLAYER
import com.alonsogp.nhl_app.features.stats.domain.TeamOneStatModel
import com.alonsogp.nhl_app.features.stats.domain.TeamStatsModel

interface StatsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(team: TeamStatsEntity)

    @Query("SELECT team_id, team_name, goals_per_game FROM $TABLE_NAME_PLAYER ORDER BY type DESC")
    fun getGoalsPerGame(): List<TeamOneStatModel>

    @Query("SELECT team_id, team_name, shots_per_game FROM $TABLE_NAME_PLAYER ORDER BY type DESC")
    fun getShotsPerGame(): List<TeamOneStatModel>

    @Query("SELECT team_id, team_name, shooting_pctg FROM $TABLE_NAME_PLAYER ORDER BY type DESC")
    fun getShootingPctg(): List<TeamOneStatModel>
}