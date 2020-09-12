package com.example.moviesapp.splash

import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.common.MovieRepository
import com.example.moviesapp.common.retrofit.RemoteMovieProvider

interface SplashRepo {
    fun fetchData(onReceived: (model: SplashModel) -> Unit)
}

class SplashRepoImpl(
    private val remoteMoviesProvider: RemoteMovieProvider,
    private val movieRepository: MovieRepository
) : SplashRepo {

    override fun fetchData(onReceived: (model: SplashModel) -> Unit) {
        remoteMoviesProvider.get(
            onSuccess = { onSuccessReceived(it, onReceived) },
            onError = { onReceived(SplashModel.Error) }
        )
    }

    private fun onSuccessReceived(
        movies: List<MovieModel>,
        onReceived: (model: SplashModel) -> Unit
    ) {
        movieRepository.set(movies)
        onReceived(SplashModel.Success)
    }
}