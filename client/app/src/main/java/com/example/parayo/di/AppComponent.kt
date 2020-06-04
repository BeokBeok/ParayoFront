package com.example.parayo.di

import com.example.parayo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, MainModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}