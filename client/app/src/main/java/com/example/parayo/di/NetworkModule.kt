package com.example.parayo.di

import com.example.parayo.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    @Named("parayoRetrofit")
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverter: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(PARAYO_HOST)
        .client(okHttpClient)
        .addConverterFactory(gsonConverter)
        .build()

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    fun provideGsonConverter(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

    companion object {
        private const val PARAYO_HOST = "http://10.0.2.2:8080/"
    }
}