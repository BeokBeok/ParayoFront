package com.example.parayo.di

import com.example.parayo.MainActivity
import com.example.parayo.repository.di.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}