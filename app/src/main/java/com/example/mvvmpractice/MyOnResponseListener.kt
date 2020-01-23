package com.example.mvvmpractice

interface MyOnResponseListener<T> {

    fun onResponse(status: Boolean, result: T?)
    fun onError(status: Boolean)
}