package com.example.movielist.common.retrofit

import com.example.movielist.common.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("json/movies.json")
    fun getFilms(): Call<List<MovieModel>>
}