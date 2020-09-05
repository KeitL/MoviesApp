package com.example.moviesapp.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.common.retrofit.RetroHelper
import com.example.moviesapp.common.DataReceivedListener

class SplashViewModel(private val retroHelper: RetroHelper): ViewModel() {
    val movieLiveData = MutableLiveData<Boolean>()

    fun onStart() {
        retroHelper.getFilms(dataReceivedListener)
    }

    var dataReceivedListener = object: DataReceivedListener<Boolean> {
        override fun onSuccess(t: Boolean?) {
            movieLiveData.postValue(t)
        }
    }

}