package com.alonsogp.nhl_app.features.standings.di

import com.alonsogp.nhl_app.features.standings.data.StandingsDataRepository
import com.alonsogp.nhl_app.features.standings.data.remote.StandingsRemoteDataSource
import com.alonsogp.nhl_app.features.standings.data.remote.api.StandingsApiRemoteSource
import com.alonsogp.nhl_app.features.standings.domain.StandingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class StandingsModule {

    @Binds
    abstract fun bindStandingsApiRemoteDataSource(remoteSource: StandingsApiRemoteSource): StandingsRemoteDataSource

    @Binds
    abstract fun bindStandingsRepository(repository: StandingsDataRepository): StandingsRepository
}