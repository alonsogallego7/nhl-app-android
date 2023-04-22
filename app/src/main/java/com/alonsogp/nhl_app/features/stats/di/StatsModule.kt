package com.alonsogp.nhl_app.features.stats.di

import com.alonsogp.nhl_app.features.stats.data.StatsDataRepository
import com.alonsogp.nhl_app.features.stats.data.local.StatsLocalDataSource
import com.alonsogp.nhl_app.features.stats.data.local.db.StatsDbLocalDataSource
import com.alonsogp.nhl_app.features.stats.data.remote.StatsRemoteDataSource
import com.alonsogp.nhl_app.features.stats.data.remote.api.StatsApiRemoteSource
import com.alonsogp.nhl_app.features.stats.domain.StatsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class StatsModule {

    @Binds
    abstract fun bindStatsApiRemoteDataSource(remoteSource: StatsApiRemoteSource): StatsRemoteDataSource

    @Binds
    abstract fun bindStatsRepository(repository: StatsDataRepository): StatsRepository

    @Binds
    abstract fun bindStatsDbLocalDataSource(localDataSource: StatsDbLocalDataSource): StatsLocalDataSource
}