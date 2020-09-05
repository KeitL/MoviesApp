package com.example.moviesapp.common

import android.app.Application
import com.example.moviesapp.main.mainModule
import com.example.moviesapp.movie.movieModule
import com.example.moviesapp.splash.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class KoinStarter {
    fun startKoin(application: Application) {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(application)
            modules(getModules())
        }
    }

    private fun getModules() = listOf(
        splashModule, mainModule, movieModule
    )
}