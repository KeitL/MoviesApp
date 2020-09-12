package com.example.moviesapp.common.retrofit

import android.util.Log
import com.example.movielist.common.model.MovieModel
import com.example.movielist.common.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface Network<T> {
    fun get(
        onSuccess: (model: T) -> Unit,
        onError: (ex: Throwable) -> Unit
    )
}

class RemoteMovieProvider(private var apiInterface: APIInterface) : Network<List<MovieModel>> {
    override fun get(
        onSuccess: (model: List<MovieModel>) -> Unit,
        onError: (ex: Throwable) -> Unit
    ) {
        apiInterface.getFilms().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                response.body()?.let {
                    onSuccess(it)
                } ?: onError(Exception("Body null"))
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                onError(t)
                Log.e("RetroHelper", "onFailure[${t.message}]")
            }
        })
    }

}