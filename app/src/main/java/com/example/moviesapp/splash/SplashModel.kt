package com.example.moviesapp.splash


sealed class SplashModel {
    object Success : SplashModel()
    object Error : SplashModel()
}