package com.alonsogp.nhl_app.features.teams.data.local.db_conferences

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConferencesDao {
    @Query("SELECT * FROM $TABLE_NAME_CONFERENCES")
    fun getAll(): List<ConferencesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(conferencesEntity: ConferencesEntity)
}