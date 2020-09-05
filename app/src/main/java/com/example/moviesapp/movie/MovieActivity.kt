package com.example.moviesapp.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.R
import kotlinx.android.synthetic.main.movie_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity() {
    val name = "Name"
    private val movieViewModel:MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        var movieName = intent.getStringExtra(name)
        if(movieName!=null){
            movieViewModel.onStart(movieName)
            movieViewModel.movieLiveData.observe(this, Observer {
                if(it!=null){
                  initMovieViews(it)
                }
            })
        }
    }

    private fun initMovieViews(movieModel: MovieModel){
        movie_activity_title.text = movieModel.title
        var genres = "Genres are ${removeLastChar(movieModel.genre.toString())}"
        movie_activity_genre.text = genres
        var rating = "Rating is ${movieModel.rating}"
        movie_activity_raiting.text = rating
        var release = "Release year is ${movieModel.releaseYear}"
        movie_activity_release.text = release
        Glide.with(this)
            .load(movieModel.image)
            .centerCrop()
            .into(movie_activity_image)
    }

    private fun removeLastChar(str: String?): String? {
        return if (str == null || str.isEmpty()) str else str.substring(1, str.length - 1)
    }
}