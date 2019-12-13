package com.example.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import java.lang.StringBuilder

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

            val chips = view.findViewById<ChipGroup>(R.id.chipGroup2)
//            val stat = view.findViewById<Switch>(R.id.On)
            val m = chips.findViewById<Chip>(R.id.monday)
            val t = chips.findViewById<Chip>(R.id.tuesday)
            val w = chips.findViewById<Chip>(R.id.wednesday)
            val th = chips.findViewById<Chip>(R.id.thursday)
            val f = chips.findViewById<Chip>(R.id.friday)
            val s = chips.findViewById<Chip>(R.id.saturday)
            val sun = chips.findViewById<Chip>(R.id.sunday)

            val chipGroup = listOf<Chip>(m,t,w,th,f,s,sun)

            for(i:Int in 0..chipGroup.size-1){
                if(alarm.day.get(i).equals('0'))
                    chipGroup.get(i).isChecked = true
                else
                    chipGroup.get(i).isChecked = false
                chipGroup.get(i).isCheckable = false;
            }

//            if(alarm.status == true)
//                stat.isChecked = true
//            else
//                stat.isChecked = false

//            stat.setOnClickListener{
//                if(alarm.status == true){
//                    stat.isChecked = false
//                    alarm.status = false
//                }
//
//                else{
//                    stat.isChecked = true
//                    alarm.status = true
//                }
//
//            }

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


