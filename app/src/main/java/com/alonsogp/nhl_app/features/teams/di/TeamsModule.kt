package com.alonsogp.nhl_app.features.teams.di

import com.alonsogp.nhl_app.features.teams.data.TeamsDataRepository
import com.alonsogp.nhl_app.features.teams.data.remote.TeamsRemoteDataSource
import com.alonsogp.nhl_app.features.teams.data.remote.api.TeamsApiRemoteSource
import com.alonsogp.nhl_app.features.teams.domain.TeamsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class TeamsModule {

    @Binds
    abstract fun bindTeamsRepository(repository: TeamsDataRepository) : TeamsRepository

    @Binds
    abstract fun bindTeamsApiRemoteDataSource(remoteSource: TeamsApiRemoteSource): TeamsRemoteDataSource

}
