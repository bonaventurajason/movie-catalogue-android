package com.bonaventurajason.moviecatalogue

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class BaseApplication: Application() {

    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate()
    }
}