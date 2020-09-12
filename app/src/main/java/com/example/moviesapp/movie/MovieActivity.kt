package com.example.moviesapp.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.common.model.MovieModel
import kotlinx.android.synthetic.main.movie_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val NAME_KEY = "Name"

class MovieActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModel()
    private val name: String by lazy {
        intent.getStringExtra(NAME_KEY) ?: throw Exception("need to be opened from getIntentFun")
    }

    companion object {
        fun getIntent(context: Context, name: String) =
            Intent(context, MovieActivity::class.java).apply {
                putExtra(NAME_KEY, name)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        initViewModels()
    }

    private fun initViewModels() {
        movieViewModel.onStart(name)
        movieViewModel.movieLiveData.observe(this, Observer {
            initMovieViews(it)
        })
    }

    private fun initMovieViews(movieModel: MovieModel) {
        setTitles(movieModel)
        loadImage(movieModel)
    }

    private fun loadImage(movieModel: MovieModel) {
        Glide.with(this)
            .load(movieModel.image)
            .centerCrop()
            .into(movie_activity_image)
    }

    private fun setTitles(movieModel: MovieModel) {
        movie_activity_title.text = movieModel.title
        val genres = "Genres are ${removeLastChar(movieModel.genre.toString())}"
        movie_activity_genre.text = genres
        movie_activity_raiting.text = "Rating is ${movieModel.rating}"
        val release = "Release year is ${movieModel.releaseYear}"
        movie_activity_release.text = release
    }

    private fun removeLastChar(str: String?): String? {
        return if (str == null || str.isEmpty()) str else str.substring(1, str.length - 1)
    }
}