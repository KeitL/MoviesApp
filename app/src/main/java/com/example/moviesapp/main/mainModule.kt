package com.example.moviesapp.main

import com.example.movielist.common.retrofit.RetroHelper
import com.example.moviesapp.common.MovieRepository
import com.example.moviesapp.common.MovieRepositoryImpl
import com.example.moviesapp.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val mainModule = module {
    viewModel{ MainViewModel(get()) }
}