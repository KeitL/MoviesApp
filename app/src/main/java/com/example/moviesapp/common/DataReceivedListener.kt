package com.example.moviesapp.common


interface DataReceivedListener<T> {
     fun onSuccess(t:T?)
}