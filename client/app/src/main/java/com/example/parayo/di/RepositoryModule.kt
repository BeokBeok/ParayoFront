package com.example.parayo.di

import com.example.parayo.data.ParayoRepository
import com.example.parayo.data.ParayoService
import com.example.parayo.data.source.ParayoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideParayoRepository(parayoService: ParayoService): ParayoDataSource =
        ParayoRepository(parayoService)

}