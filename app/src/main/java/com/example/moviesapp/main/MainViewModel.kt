package com.example.moviesapp.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.common.MovieRepository

class MainViewModel(val movieRepository: MovieRepository): ViewModel() {
    val movieLiveData = MutableLiveData<List<MovieModel>>()

    fun onStart() {
        movieLiveData.postValue(movieRepository.getFilms())
    }

}