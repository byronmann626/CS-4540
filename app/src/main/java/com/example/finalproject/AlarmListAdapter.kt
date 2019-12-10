package com.example.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlarmListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<AlarmListAdapter.AlarmViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var alarms = emptyList<Alarm>() // Cached copy of words

    inner class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alarmItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return AlarmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val current = alarms[position]
        if(current.min < 10)
            holder.alarmItemView.text = "${current.hour}:0${current.min}"
        else
            holder.alarmItemView.text = "${current.hour}:${current.min}"
    }

    internal fun setAlarms(alarms: List<Alarm>) {
        this.alarms = alarms
        notifyDataSetChanged()
    }

    override fun getItemCount() = alarms.size
}