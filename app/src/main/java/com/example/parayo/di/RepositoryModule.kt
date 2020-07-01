package com.example.parayo.di

import com.example.parayo.domain.auth.AuthDataSource
import com.example.parayo.domain.auth.AuthRepository
import com.example.parayo.domain.auth.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService): AuthDataSource =
        AuthRepository(authService)
}