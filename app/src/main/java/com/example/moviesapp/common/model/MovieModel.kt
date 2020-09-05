package com.example.movielist.common.model

import com.google.gson.annotations.SerializedName

class MovieModel() {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("rating")
    var rating: Double? = null
    @SerializedName("releaseYear")
    var releaseYear: Int? = null
    @SerializedName("genre")
    var genre: List<String>? = null

    override fun toString(): String {
        return "MovieRepo(title=$title, image=$image, rating=$rating, releaseYear=$releaseYear, genre=$genre)"
    }
}