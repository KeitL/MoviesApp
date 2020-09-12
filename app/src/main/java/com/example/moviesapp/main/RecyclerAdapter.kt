package com.example.moviesapp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.common.model.MovieModel
import kotlinx.android.synthetic.main.movie_item.view.*

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieData: MutableList<MovieModel> = mutableListOf<MovieModel>()
    var onItemClick: ((id: String) -> Unit)? = null

    fun update(data: List<MovieModel>) {
        movieData.clear()
        movieData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

    }
}

class MovieViewHolder(view: View, private val onItemClick: ((id: String) -> Unit)? = null) :
    RecyclerView.ViewHolder(view) {
    val layout = view.layout
    val movieIcom = view.movie_activity_image
    val movieTitle: TextView = view.movie_activity_title
    val movieRelease: TextView = view.movie_activity_release
    val movieRaiting = view.movie_activity_raiting
    val movieGenre = view.movie_activity_genre

    fun bind(model: MovieModel) {
        movieTitle.text = model.title
        movieRelease.text = "Release year is ${model.releaseYear}"
        movieGenre.text = "Genres are ${removeLastChar(model.genre.toString())}"
        movieRaiting.text = "Rating is ${model.rating}"

        Glide.with(movieIcom)
            .load(model.image)
            .centerCrop() //4
            .into(movieIcom)

        layout.setOnClickListener {
            onItemClick?.invoke(model.title)
        }


    }

    private fun removeLastChar(str: String?): String? {
        return if (str.isNullOrEmpty()) str else str.substring(1, str.length - 1)
    }
}