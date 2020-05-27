package com.example.parayo.repository.di

import com.example.parayo.repository.ParayoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ServiceModule {

    @Provides
    @Singleton
    fun provideParayoService(@Named("parayoRetrofit") retrofit: Retrofit): ParayoService =
        retrofit.create(ParayoService::class.java)
}