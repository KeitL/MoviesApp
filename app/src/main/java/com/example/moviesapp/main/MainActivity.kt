package com.example.moviesapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.ItemClickedListener
import com.example.moviesapp.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val name = "Name"

    val listener = object:ItemClickedListener<String>{
        override fun itemClicked(t: String?) {
            var intent = Intent(this@MainActivity, MovieActivity::class.java)
            intent.putExtra(name, t)
            startActivity(intent)
        }
    }

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.onStart()
        mainViewModel.movieLiveData.observe(this, Observer {
            recycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerAdapter(it, context, listener)
            }
        })

    }
}