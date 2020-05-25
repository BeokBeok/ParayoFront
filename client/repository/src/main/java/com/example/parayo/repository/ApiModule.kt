package com.example.parayo.repository

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideParayoApi(@Named("parayoRetrofit") retrofit: Retrofit): ParayoApi =
        retrofit.create(ParayoApi::class.java)
}