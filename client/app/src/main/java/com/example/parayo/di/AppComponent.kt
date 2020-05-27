package com.example.parayo.di

import com.example.parayo.MainActivity
import com.example.parayo.repository.di.ServiceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, MainModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}