package com.example.moviesapp.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel(private val splashRepo: SplashRepo) : ViewModel() {
    val movieLiveData = MutableLiveData<SplashModel>()

    fun onStart() {
        splashRepo.fetchData { model ->
            movieLiveData.postValue(model)
        }
    }
}
