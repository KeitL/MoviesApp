package com.example.moviesapp.common.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("releaseYear")
    val releaseYear: Int,
    @SerializedName("genre")
    val genre: List<String>
)