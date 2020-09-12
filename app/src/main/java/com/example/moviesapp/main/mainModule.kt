package com.example.moviesapp.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val mainModule = module {
    viewModel{ MainViewModel(get()) }
}