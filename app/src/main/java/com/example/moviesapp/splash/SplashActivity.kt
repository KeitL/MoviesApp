package com.example.moviesapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.moviesapp.R
import com.example.moviesapp.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.onStart()
        splashViewModel.movieLiveData.observe(this, Observer {
            when(it){
                is SplashModel.Success -> openRelevantActivity()
                is SplashModel.Error -> Toast.makeText(this, "blabla", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //todo refactor
    //todo impl koin

    private fun openRelevantActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}