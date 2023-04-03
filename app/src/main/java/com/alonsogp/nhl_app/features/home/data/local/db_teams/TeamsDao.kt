package com.alonsogp.nhl_app.features.home.data.local.db_teams

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamsDao {
    @Query("SELECT * FROM $TABLE_NAME_TEAMS WHERE division_id = :divisionId")
    fun getTeamsByDivision(divisionId: Int): List<TeamEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(teams: List<TeamEntity>)
}