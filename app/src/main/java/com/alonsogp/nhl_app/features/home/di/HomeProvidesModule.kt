package com.alonsogp.nhl_app.features.home.di

import com.alonsogp.nhl_app.app.data.local.db.AppDatabase
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.TeamDetailDao
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamsDao
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeProvidesModule {
    @Singleton
    @Provides
    fun providesTeamsApiEndPoints(retrofit: Retrofit): HomeApiEndPoints =
        retrofit.create(HomeApiEndPoints::class.java)

    @Provides
    @Singleton
    fun provideTeamsDao(appDatabase: AppDatabase): TeamsDao =
        appDatabase.teamsDao()

    @Provides
    @Singleton
    fun provideTeamsDetailDao(appDatabase: AppDatabase): TeamDetailDao =
        appDatabase.teamDetailDao()

}