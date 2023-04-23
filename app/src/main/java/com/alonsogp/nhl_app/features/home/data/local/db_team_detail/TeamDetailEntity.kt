package com.alonsogp.nhl_app.features.home.data.local.db_team_detail

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_TEAM_DETAIL = "teams_detail"
const val TABLE_NAME_VENUE = "venues"

@Entity(tableName = TABLE_NAME_TEAM_DETAIL)
data class TeamDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val id: Int,
    @ColumnInfo(name = "team_detail_name") val name: String,
    @Embedded val venue: VenueEntity,
    @ColumnInfo val abbreviation: String,
    @ColumnInfo(name = "first_year_of_play") val firstYearOfPlay: String,
)

@Entity(tableName = TABLE_NAME_VENUE)
data class VenueEntity(
    @PrimaryKey
    @ColumnInfo(name = "venue_id") val id: Int,
    @ColumnInfo(name = "team_name") val name: String,
    @ColumnInfo val city: String
)
