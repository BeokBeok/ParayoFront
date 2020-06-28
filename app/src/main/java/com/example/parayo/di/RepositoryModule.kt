package com.example.parayo.di

import com.example.parayo.domain.AuthDataSource
import com.example.parayo.domain.AuthRepository
import com.example.parayo.domain.AuthService
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