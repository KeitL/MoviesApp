package com.example.moviesapp.common

import android.util.Log
import com.example.movielist.common.model.MovieModel
import com.example.movielist.common.retrofit.RetroHelper

interface MovieRepository {
    fun downloadFilms(list:List<MovieModel>?);
    fun getFilms(): List<MovieModel>?
    fun getFilmById(name: String?): MovieModel?
}

class MovieRepositoryImpl:MovieRepository{
    private var movieList:List<MovieModel>? = null

    override fun downloadFilms(list: List<MovieModel>?) {
        movieList = list

    }

    override fun getFilms(): List<MovieModel>? {
        return movieList
    }

    override fun getFilmById(name: String?): MovieModel? {
        var movieModel:MovieModel? = null
        for (i in movieList!!){
           if (name.equals(i.title)){
               movieModel = i
           }
        }
        return movieModel
    }
}