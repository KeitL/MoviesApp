package com.example.moviesapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.model.MovieModel
import com.example.moviesapp.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private val movieAdapter = RecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModels()
    }

    private fun initViewModels() {
        mainViewModel.onStart()
        mainViewModel.movieLiveData.observe(this, Observer {
            onDataReceived(it)
        })
    }

    private fun onDataReceived(data: List<MovieModel>) {
        movieAdapter.update(data)
    }

    private fun initViews() {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        movieAdapter.onItemClick = {
            MovieActivity.getIntent(this, it).apply {
                startActivity(this)
            }
        }
    }
}


