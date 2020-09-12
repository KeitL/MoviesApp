@file:Suppress("RemoveExplicitTypeArguments")

package com.example.moviesapp.main

import com.example.moviesapp.common.MovieRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val mainModule = module {
    viewModel { MainViewModel(get<MovieRepository>()) }
}