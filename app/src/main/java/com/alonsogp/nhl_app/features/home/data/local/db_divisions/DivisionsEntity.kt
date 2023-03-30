package com.alonsogp.nhl_app.features.home.data.local.db_divisions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_DIVISIONS = "divisions"

@Entity(tableName = TABLE_NAME_DIVISIONS)
data class DivisionEntity(
    @PrimaryKey
    @ColumnInfo val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo(name = "conference_id") val conferenceId: Int
)