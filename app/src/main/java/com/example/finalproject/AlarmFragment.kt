package com.example.finalproject


import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.FragmentAlarmBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_alarm.*
import java.security.acl.Owner


class AlarmFragment : Fragment() {

    lateinit var alarmViewModel: AlarmViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAlarmBinding>(inflater,
            R.layout.fragment_alarm,container,false)
        val mediaPlayer= MediaPlayer.create(context,R.raw.wakemeup)
        mediaPlayer.stop()
        val act = this.activity as Activity
        val adapter = AlarmListAdapter(act)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(act)

        alarmViewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        alarmViewModel.allWords.observe(act as LifecycleOwner, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setAlarms(it) }

        })


        binding.addAlarmButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_alarmFragment_to_settingsFragment)
        }

        return binding.root
    }




}