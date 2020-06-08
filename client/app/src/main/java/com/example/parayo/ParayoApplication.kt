package com.example.parayo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ParayoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ParayoApplication
    }
}