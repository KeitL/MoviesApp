package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.common.KoinStarter

class App : Application() {

    private val koinStarter: KoinStarter = KoinStarter()
    override fun onCreate() {
        super.onCreate()
        koinStarter.startKoin(this)
    }
}