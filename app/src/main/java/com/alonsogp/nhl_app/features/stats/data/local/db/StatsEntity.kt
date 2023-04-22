package com.alonsogp.nhl_app.features.stats.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_TEAM_STATS = "team_stats"

@Entity(tableName = TABLE_NAME_TEAM_STATS)
data class TeamStatsEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val id: Int,
    @ColumnInfo(name = "team_name") val name: String,
    @ColumnInfo(name = "goals_per_game") val goalsPerGame: String,
    @ColumnInfo(name = "shots_per_game") val shotsPerGame: String,
    @ColumnInfo(name = "shooting_pctg") val shootingPctg: String
)

@Entity(tableName = "team_goals")
data class StatGoalsPerGameEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val id: Int,
    @ColumnInfo(name = "team_name") val name: String,
    @ColumnInfo(name = "goals_per_game") val goalsPerGame: String
)

@Entity(tableName = "team_shots")
data class StatShotsPerGameEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val id: Int,
    @ColumnInfo(name = "team_name") val name: String,
    @ColumnInfo(name = "shots_per_game") val shotsPerGame: String
)

@Entity(tableName = "team_shooting")
data class StatShootingPctgEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val id: Int,
    @ColumnInfo(name = "team_name") val name: String,
    @ColumnInfo(name = "shooting_pctg") val shootingPctg: String
)