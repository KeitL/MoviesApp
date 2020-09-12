@file:Suppress("RemoveExplicitTypeArguments")

package com.example.moviesapp.splash

import com.example.moviesapp.common.MovieRepository
import com.example.moviesapp.common.MovieRepositoryImpl
import com.example.moviesapp.common.retrofit.RemoteMovieProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single<MovieRepository> { MovieRepositoryImpl() }
    single<RemoteMovieProvider> { RemoteMovieProvider(get()) }
    single<SplashRepo> { SplashRepoImpl(get<RemoteMovieProvider>(), get<MovieRepository>()) }
    viewModel { SplashViewModel(get()) }
}
