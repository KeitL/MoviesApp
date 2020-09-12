package com.example.moviesapp.common

import com.example.movielist.common.model.MovieModel

interface MovieRepository {
    fun set(list:List<MovieModel>)
    fun getAll(): List<MovieModel>?
    fun getById(name: String?): MovieModel?
}

class MovieRepositoryImpl:MovieRepository{
    private var movieList:List<MovieModel>? = null

    override fun set(list: List<MovieModel>) {
        movieList = list
    }

    override fun getAll(): List<MovieModel>? {
        return movieList
    }

    override fun getById(name: String?): MovieModel? {
        var movieModel:MovieModel? = null
        for (i in movieList!!){
           if (name.equals(i.title)){
               movieModel = i
           }
        }
        return movieModel
    }
}