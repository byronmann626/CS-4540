package com.example.finalproject

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.finalproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    private lateinit var alarmViewModel: AlarmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);

//        val adapter = AlarmListAdapter(this)
//        recyclerview?.adapter = adapter
//        recyclerview?.layoutManager = LinearLayoutManager(this)
//
//        alarmViewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
//        alarmViewModel.allWords.observe(this, Observer { words ->
//            // Update the cached copy of the words in the adapter.
//            words?.let { adapter.setAlarms(it) }
//        })

    }
}