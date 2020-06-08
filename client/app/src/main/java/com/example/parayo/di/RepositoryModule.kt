package com.example.parayo.di

import com.example.parayo.domain.AuthDataSource
import com.example.parayo.domain.AuthRepository
import com.example.parayo.domain.AuthService
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
    fun provideAuthRepository(authService: AuthService): AuthDataSource =
        AuthRepository(authService)
}