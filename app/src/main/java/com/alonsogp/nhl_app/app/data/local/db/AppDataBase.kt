package com.alonsogp.nhl_app.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogp.nhl_app.BuildConfig
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.*
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamEntity
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamsDao
import com.alonsogp.nhl_app.features.stats.data.local.db.*

@Database(
    entities = [TeamEntity::class, TeamDetailEntity::class, VenueEntity::class, PlayerEntity::class, PersonEntity::class, PositionEntity::class, TeamStatsEntity::class, StatGoalsPerGameEntity::class, StatShotsPerGameEntity::class, StatShootingPctgEntity::class],
    version = BuildConfig.VERSION_CODE
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamsDao(): TeamsDao
    abstract fun teamDetailDao(): TeamDetailDao
    abstract fun statsDao(): StatsDao
}