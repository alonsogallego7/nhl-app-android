package com.alonsogp.nhl_app.features.stats.di

import com.alonsogp.nhl_app.app.data.local.db.AppDatabase
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.TeamDetailDao
import com.alonsogp.nhl_app.features.stats.data.local.db.StatsDao
import com.alonsogp.nhl_app.features.stats.data.remote.api.StatsApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object StatsProvidesModule {
    @Singleton
    @Provides
    fun providesStatsApiEndPoints(retrofit: Retrofit): StatsApiEndPoints =
        retrofit.create(StatsApiEndPoints::class.java)

    @Provides
    @Singleton
    fun provideStatsDao(appDatabase: AppDatabase): StatsDao =
        appDatabase.statsDao()

}