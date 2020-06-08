package com.example.parayo.di

import com.example.parayo.domain.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideParayoService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
}