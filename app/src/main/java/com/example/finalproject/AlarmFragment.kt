package com.example.finalproject


import android.app.Activity
import android.media.MediaPlayer

import android.os.Bundle
import android.util.Log
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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlarmFragment : Fragment() {
    lateinit var alarmViewModel: AlarmViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mediaPlayer= MediaPlayer.create(context,R.raw.wakemeup)
        mediaPlayer.stop()
        val binding = DataBindingUtil.inflate<FragmentAlarmBinding>(
            inflater,
            R.layout.fragment_alarm, container, false
        )

        val act = this.activity as Activity
        val adapter = AlarmListAdapter(act)
        binding.recyclerview.layoutManager = LinearLayoutManager(act,LinearLayoutManager.VERTICAL,false)
        binding.recyclerview.adapter = adapter

        alarmViewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        alarmViewModel.allAlarms.observe(act as LifecycleOwner, Observer { alarms ->
            // Update the cached copy of the words in the adapter.
            alarms?.let { adapter.setAlarms(it as ArrayList<Alarm>) }
        })

        setRecyclerViewItemTouchListener(binding.recyclerview, adapter.alarms)

        binding.addAlarmButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_alarmFragment_to_settingsFragment)
        }


        return binding.root
    }


    private fun setRecyclerViewItemTouchListener(recyclerView: RecyclerView, alarmList: ArrayList<Alarm>) {

        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                //2
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                //3
                val position = viewHolder.adapterPosition
                alarmViewModel.delete(alarmViewModel.allAlarms.value?.get(position) as Alarm)
                recyclerView.adapter!!.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

}