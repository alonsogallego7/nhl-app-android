package com.alonsogp.nhl_app.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogp.nhl_app.BuildConfig
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferenceEntity
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferencesDao

@Database(
    entities = [ConferenceEntity::class],
    version = BuildConfig.VERSION_CODE
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun conferencesDao(): ConferencesDao
}