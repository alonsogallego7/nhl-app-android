package com.alonsogp.nhl_app.features.teams.di

import com.alonsogp.nhl_app.features.teams.data.remote.api.TeamsApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TeamsProvidesModule {
    @Singleton
    @Provides
    fun providesTeamsApiEndPoints(retrofit: Retrofit) : TeamsApiEndPoints =
        retrofit.create(TeamsApiEndPoints::class.java)

    /*
    @Provides
    @Singleton
    fun provideNewsDao(appDatabase: AppDatabase) : NewsDao =
        appDatabase.newsDao()
    */
}