package com.example.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        supportFragmentManager.beginTransaction().add(R.id.topFrameLayout, TopFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.bottomFrameLayout, BottomFragment()).commit()

        mainViewModel.getInputNumber().observe(this, Observer {
            centerTextView.setText("Your Entered Value: "+ it)
        })

    }
}
