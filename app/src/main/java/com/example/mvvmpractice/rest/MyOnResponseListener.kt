package com.example.mvvmpractice.rest

interface MyOnResponseListener<T> {

    fun onResponse(status: Boolean, result: T?)
    fun onError(status: Boolean)
}