package com.alonsogp.nhl_app.features.home.data.local.db_team_detail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDetailDao {
    @Query("SELECT * FROM $TABLE_NAME_TEAM_DETAIL WHERE team_id = :teamId")
    fun getTeamDetailById(teamId: Int): TeamDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeam(team: TeamDetailEntity)

    @Query("SELECT * FROM $TABLE_NAME_PLAYER WHERE team_id = :teamId")
    fun getPlayersById(teamId: Int): List<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun savePlayer(player: PlayerEntity)
}