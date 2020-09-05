package com.example.movielist.common.retrofit

import android.util.Log
import com.example.movielist.common.model.MovieModel
import com.example.moviesapp.common.DataReceivedListener
import com.example.moviesapp.common.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroHelper(private val movieRepository: MovieRepository) {
    private var apiInterface: APIInterface? = null
    init {
        apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    }


    fun getFilms(dataReceivedListener: DataReceivedListener<Boolean>){
        if (apiInterface != null) {
            val call: Call<List<MovieModel>> = apiInterface!!.getFilms()
            call.enqueue(object : Callback<List<MovieModel>> {
                override fun onResponse(
                    call: Call<List<MovieModel>>,
                    response: Response<List<MovieModel>>
                ) { movieRepository.downloadFilms(response.body())
                    dataReceivedListener.onSuccess(true)
                }
                override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                    Log.e("xxx", "error is ${t.message}")
                }

            })
        }
    }
}