package com.example.moviesapp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.R
import com.example.moviesapp.common.ItemClickedListener
import kotlinx.android.synthetic.main.movie_item.view.*

class RecyclerAdapter(private val moviesList: List<MovieModel>, val context: Context,val itemClickedListener: ItemClickedListener<String>) : RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>() {


    class MovieViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val layout = view.layout
        val movieIcom = view.movie_activity_image
        val movieTitle = view.movie_activity_title
        val movieRelease = view.movie_activity_release
        val movieRaiting = view.movie_activity_raiting
        val movieGenre = view.movie_activity_genre
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movieModel = moviesList.get(position)
        holder.movieTitle.text = movieModel.title
        var release = "Release year is ${movieModel.releaseYear} "
        holder.movieRelease.text = release
        var genres = "Genres are ${removeLastChar(movieModel.genre.toString())}"
        holder.movieGenre.text = genres
        var rating = "Rating is ${movieModel.rating}"
        holder.movieRaiting.text = rating

        Glide.with(context)
            .load(movieModel.image)
            .centerCrop() //4
            .into(holder.movieIcom)

        holder.layout.setOnClickListener {
            itemClickedListener.itemClicked(movieModel.title)
        }
    }

    private fun removeLastChar(str: String?): String? {
        return if (str == null || str.isEmpty()) str else str.substring(1, str.length - 1)
    }


}