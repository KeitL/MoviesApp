package com.example.moviesapp.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.common.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository):ViewModel() {
    val movieLiveData = MutableLiveData<MovieModel>()

    fun onStart(name: String?) {
        movieLiveData.postValue(movieRepository.getById(name))
    }
}