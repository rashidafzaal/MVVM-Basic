package com.example.mvvmpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var myRepo: MainRepository

    init {
        myRepo = MainRepository.getRepo()
    }

    fun login(myListener: MyOnResponseListener<String>){
        myRepo.login(myListener)
    }

}