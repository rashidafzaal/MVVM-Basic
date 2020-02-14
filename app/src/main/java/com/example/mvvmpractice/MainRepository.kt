package com.example.mvvmpractice

import androidx.lifecycle.MutableLiveData
import com.example.mvvmpractice.rest.APIs
import com.example.mvvmpractice.rest.ApiClient
import com.example.mvvmpractice.rest.MyOnResponseListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private var loginResponseLiveData = MutableLiveData<String>()

    companion object {
        @Volatile
        private var INSTANCE: MainRepository? = null
        fun getRepo(): MainRepository {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = MainRepository()
                }
            }
            return INSTANCE!!
        }
    }

    fun login(myListener: MyOnResponseListener<String>): MutableLiveData<String>{
        var api = ApiClient.getClient().create(APIs::class.java)
        var call = api.login(" ", " ")
        call.enqueue(object: Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                myListener.onError(false)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                loginResponseLiveData.value = response.body()
                myListener.onResponse(true, response.body())
            }
        })
        return loginResponseLiveData
    }

}