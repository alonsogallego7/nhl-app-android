package com.alonsogp.nhl_app.features.home.di

import com.alonsogp.nhl_app.features.home.data.TeamDetailDataRepository
import com.alonsogp.nhl_app.features.home.data.TeamsDataRepository
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.TeamsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.TeamDetailDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamsDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.TeamDetailRepository
import com.alonsogp.nhl_app.features.home.domain.TeamsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindTeamsApiRemoteDataSource(remoteSource: HomeApiRemoteSource): HomeRemoteDataSource

    //Teams

    @Binds
    abstract fun bindTeamsRepository(repository: TeamsDataRepository): TeamsRepository

    @Binds
    abstract fun bindTeamsDbLocalDataSource(localDataSource: TeamsDbLocalDataSource): TeamsLocalDataSource

    //Team Detail

    @Binds
    abstract fun bindTeamDetailRepository(repository: TeamDetailDataRepository): TeamDetailRepository

    @Binds
    abstract fun bindTeamDetailDbLocalDataSource(localDataSource: TeamDetailDbLocalDataSource): TeamDetailLocalDataSource

}
