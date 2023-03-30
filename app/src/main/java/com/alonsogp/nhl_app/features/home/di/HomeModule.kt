package com.alonsogp.nhl_app.features.home.di

import com.alonsogp.nhl_app.features.home.data.ConferencesDataRepository
import com.alonsogp.nhl_app.features.home.data.local.ConferencesLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferencesDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.ConferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindTeamsApiRemoteDataSource(remoteSource: HomeApiRemoteSource): HomeRemoteDataSource

    @Binds
    abstract fun bindConferencesRepository(repository: ConferencesDataRepository) : ConferencesRepository

    @Binds
    abstract fun bindConferencesDbLocalDataSource(localDataSource: ConferencesDbLocalDataSource) : ConferencesLocalDataSource

}
