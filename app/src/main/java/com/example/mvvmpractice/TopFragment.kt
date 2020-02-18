package com.example.mvvmpractice


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_top.*
import kotlinx.android.synthetic.main.fragment_top.view.*

/**
 * A simple [Fragment] subclass.
 */
class TopFragment : Fragment() {

    private lateinit var rootview: View
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview = inflater.inflate(R.layout.fragment_top, container, false)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer
        mainViewModel.getInput().observe(this, Observer {
            topFragTextView.text = it
            if (it.isEmpty())
                topFragTextView.text = "- - -"
        })

    }


}
