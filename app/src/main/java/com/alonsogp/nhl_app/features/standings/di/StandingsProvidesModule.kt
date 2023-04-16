package com.alonsogp.nhl_app.features.standings.di

import com.alonsogp.nhl_app.features.standings.data.remote.api.StandingsApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StandingsProvidesModule {
    @Singleton
    @Provides
    fun providesStandingsApiEndPoints(retrofit: Retrofit): StandingsApiEndPoints =
        retrofit.create(StandingsApiEndPoints::class.java)

}