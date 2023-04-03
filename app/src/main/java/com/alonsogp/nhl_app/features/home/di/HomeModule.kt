package com.alonsogp.nhl_app.features.home.di

import com.alonsogp.nhl_app.features.home.data.ConferencesDataRepository
import com.alonsogp.nhl_app.features.home.data.DivisionsDataRepository
import com.alonsogp.nhl_app.features.home.data.TeamDetailDataRepository
import com.alonsogp.nhl_app.features.home.data.TeamsDataRepository
import com.alonsogp.nhl_app.features.home.data.local.ConferencesLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.DivisionsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.TeamDetailLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.TeamsLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_conferences.ConferencesDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_divisions.DivisionsDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_team_detail.TeamDetailDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.local.db_teams.TeamsDbLocalDataSource
import com.alonsogp.nhl_app.features.home.data.remote.HomeRemoteDataSource
import com.alonsogp.nhl_app.features.home.data.remote.api.HomeApiRemoteSource
import com.alonsogp.nhl_app.features.home.domain.ConferencesRepository
import com.alonsogp.nhl_app.features.home.domain.DivisionsRepository
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

    //Conferences

    @Binds
    abstract fun bindConferencesRepository(repository: ConferencesDataRepository): ConferencesRepository

    @Binds
    abstract fun bindConferencesDbLocalDataSource(localDataSource: ConferencesDbLocalDataSource): ConferencesLocalDataSource

    //Divisions

    @Binds
    abstract fun bindDivisionsRepository(repository: DivisionsDataRepository): DivisionsRepository

    @Binds
    abstract fun bindDivisionsDbLocalDataSource(localDataSource: DivisionsDbLocalDataSource): DivisionsLocalDataSource

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
