package com.example.moviesapp.movie


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val movieModule = module {
    viewModel{ MovieViewModel(get()) }
}