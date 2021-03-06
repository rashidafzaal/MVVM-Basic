package com.example.mvvmpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmpractice.rest.MyOnResponseListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        callLogin()

        observerBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun callLogin() {
        mainViewModel.login(myListener)
    }

    val myListener = object: MyOnResponseListener<String> {
        override fun onError(status: Boolean) {
            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(status: Boolean, result: String?) {
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}
