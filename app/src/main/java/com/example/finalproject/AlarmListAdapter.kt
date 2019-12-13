package com.example.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class AlarmListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<AlarmListAdapter.AlarmHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var alarms = ArrayList<Alarm>() // Cached copy of words

    internal fun setAlarms(alarms: ArrayList<Alarm>) {
        this.alarms = alarms
        notifyDataSetChanged()
    }

    override fun getItemCount() = alarms.size


    override fun onBindViewHolder(holder: AlarmHolder, position: Int) {
        val alarm = alarms[position]
        holder.bindAlarm(alarm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item, false)
        return AlarmHolder(inflatedView)
    }

    class AlarmHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var alarm: Alarm? = null

        //3
        init {
            v.setOnClickListener(this)
        }


        fun bindAlarm(alarm: Alarm) {
            this.alarm = alarm
            if (alarm.min < 10)
                view.individual.text = "${alarm.hour}:0${alarm.min}"
            else
                view.individual.text = "${alarm.hour}:${alarm.min}"
        }

        override fun onClick(v: View) {
//            val context = itemView.context
//            view.findNavController().navigate(R.id.action_alarmFragment_to_settingsFragment)
        }

        companion object {
            //5
            private val ALARM_KEY = "ALARM"
        }
    }
}


