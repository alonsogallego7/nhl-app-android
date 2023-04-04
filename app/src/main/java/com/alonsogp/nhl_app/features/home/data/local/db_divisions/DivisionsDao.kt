package com.alonsogp.nhl_app.features.home.data.local.db_divisions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DivisionsDao {
    @Query("SELECT * FROM $TABLE_NAME_DIVISIONS WHERE conference_id = :conferenceId")
    fun getDivisionsByConference(conferenceId: Int): List<DivisionEntity>

    @Insert
    fun save(division: DivisionEntity)
}