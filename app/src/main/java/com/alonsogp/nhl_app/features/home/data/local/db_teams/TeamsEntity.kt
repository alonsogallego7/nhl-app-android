package com.alonsogp.nhl_app.features.home.data.local.db_teams

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_TEAMS = "teams"

@Entity(tableName = TABLE_NAME_TEAMS)
data class TeamEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val abbreviation: String,
    @ColumnInfo val logoUrl: String,
    @ColumnInfo(name = "division_id") val divisionId: Int
)