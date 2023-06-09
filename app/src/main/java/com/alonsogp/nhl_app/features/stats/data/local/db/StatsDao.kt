package com.alonsogp.nhl_app.features.stats.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StatsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(team: TeamStatsEntity)

    @Query("SELECT team_id, team_name, goals_per_game FROM $TABLE_NAME_TEAM_STATS ORDER BY goals_per_game DESC")
    fun getGoalsPerGame(): List<StatGoalsPerGameEntity>

    @Query("SELECT team_id, team_name, shots_per_game FROM $TABLE_NAME_TEAM_STATS ORDER BY shots_per_game DESC")
    fun getShotsPerGame(): List<StatShotsPerGameEntity>

    @Query("SELECT team_id, team_name, shooting_pctg FROM $TABLE_NAME_TEAM_STATS ORDER BY shooting_pctg DESC")
    fun getShootingPctg(): List<StatShootingPctgEntity>
}