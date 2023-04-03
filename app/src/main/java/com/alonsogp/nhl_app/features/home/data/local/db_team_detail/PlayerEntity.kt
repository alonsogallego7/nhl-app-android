package com.alonsogp.nhl_app.features.home.data.local.db_team_detail

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_PLAYER = "players"
const val TABLE_NAME_PERSON = "persons"
const val TABLE_NAME_POSITION = "positions"

@Entity(tableName = TABLE_NAME_PLAYER)
data class PlayerEntity(
    @PrimaryKey
    @ColumnInfo(name = "player_id") val id: Int,
    @Embedded val person: PersonEntity,
    @ColumnInfo(name = "jersey_number") val jerseyNumber: String,
    @Embedded val position: PositionEntity,
    @ColumnInfo(name = "team_id") val teamId: Int
)

@Entity(tableName = TABLE_NAME_PERSON)
data class PersonEntity(
    @PrimaryKey
    @ColumnInfo(name = "person_id") val id: Int,
    @ColumnInfo(name = "full_name") val fullName: String
)

@Entity(tableName = TABLE_NAME_POSITION)
data class PositionEntity(
    @PrimaryKey
    @ColumnInfo(name = "position_id") val id: Int,
    @ColumnInfo(name = "position") val name: String,
    @ColumnInfo val type: String
)