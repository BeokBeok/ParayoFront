package com.example.parayo.di

import com.example.parayo.domain.AuthRepository
import com.example.parayo.domain.AuthService
import com.example.parayo.domain.remote.AuthDataSource
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
    fun provideParayoRepository(authService: AuthService): AuthDataSource =
        AuthRepository(authService)
}