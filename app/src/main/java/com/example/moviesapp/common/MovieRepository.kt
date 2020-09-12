package com.example.moviesapp.common

import com.example.moviesapp.common.model.MovieModel
import java.lang.Exception

interface MovieRepository {
    fun set(list: List<MovieModel>)
    fun getAll(): List<MovieModel>
    fun getById(name: String): MovieModel
}

class MovieRepositoryImpl : MovieRepository {
    private var movieList: List<MovieModel>? = null

    override fun set(list: List<MovieModel>) {
        movieList = list
    }

    override fun getAll(): List<MovieModel> {
        return movieList ?: emptyList()
    }

    override fun getById(name: String): MovieModel {
        return movieList?.find { it.title == name } ?: throw  Exception("no movie")
    }
}