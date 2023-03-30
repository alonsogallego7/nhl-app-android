package com.alonsogp.nhl_app.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogp.nhl_app.BuildConfig
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferenceEntity
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferencesDao
import com.alonsogp.nhl_app.features.home.data.local.db_divisions.DivisionEntity
import com.alonsogp.nhl_app.features.home.data.local.db_divisions.DivisionsDao
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamEntity
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamsDao

@Database(
    entities = [ConferenceEntity::class, DivisionEntity::class, TeamEntity::class],
    version = BuildConfig.VERSION_CODE
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun conferencesDao(): ConferencesDao
    abstract fun divisionsDao(): DivisionsDao
    abstract fun teamsDao(): TeamsDao
}