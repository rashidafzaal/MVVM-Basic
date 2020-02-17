package com.example.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        enterNumberEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.setInput(s.toString())
                if (s.isNullOrEmpty()) {
                    mainViewModel.setInput("")
                }
            }

        })

        mainViewModel.getInput().observe(this, Observer {
            enteredValue.setText(it)
            if (it.isEmpty()) {
                enteredValue.setText("- - -")
            }
        })

    }
}
