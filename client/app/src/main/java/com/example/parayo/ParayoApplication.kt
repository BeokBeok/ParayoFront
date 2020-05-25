package com.example.parayo

import android.app.Application
import com.example.parayo.di.AppComponent
import com.example.parayo.di.AppComponentProvider
import com.example.parayo.di.DaggerAppComponent

class ParayoApplication : Application(),
    AppComponentProvider {

    override fun getAppComponent(): AppComponent =
        DaggerAppComponent.builder().build()
}