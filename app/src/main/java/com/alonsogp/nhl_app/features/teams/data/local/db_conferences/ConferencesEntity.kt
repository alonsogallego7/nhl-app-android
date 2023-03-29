package com.alonsogp.nhl_app.features.teams.data.local.db_conferences

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_CONFERENCES = "conferences"

@Entity(tableName = TABLE_NAME_CONFERENCES)
data class ConferencesEntity(
    @PrimaryKey
    @ColumnInfo val id: Int,
    @ColumnInfo val name: String
)