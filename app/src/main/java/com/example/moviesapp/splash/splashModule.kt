package com.example.moviesapp.splash

import com.example.movielist.common.retrofit.RetroHelper
import com.example.moviesapp.common.MovieRepository
import com.example.moviesapp.common.MovieRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val splashModule = module {
    single<MovieRepository> { MovieRepositoryImpl() }
    single { RetroHelper(get()) }
    viewModel{SplashViewModel(get())}
}
