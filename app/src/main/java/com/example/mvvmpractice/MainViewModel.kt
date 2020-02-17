package com.example.mvvmpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmpractice.rest.MyOnResponseListener

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var inputNumber = MutableLiveData<String>()

    private var myRepo: MainRepository

    init {
        myRepo = MainRepository.getRepo()
    }

    fun login(myListener: MyOnResponseListener<String>){
        myRepo.login(myListener)
    }

    fun getInput(): MutableLiveData<String> {
        return inputNumber
    }

    fun setInput(input: String) {
         inputNumber.value = input
    }

}