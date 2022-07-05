package com.example.carttask.components

import android.app.Application
import com.example.business.local.PreferencesManager

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesManager.with(this)
    }
}