package com.example.finalproject

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import com.example.finalproject.databinding.FragmentSettingsBinding
import androidx.navigation.findNavController
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_settings.view.*

import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSettingsBinding>(inflater,
            R.layout.fragment_settings,container,false)
        binding.okButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_settingsFragment_to_alarmFragment3)
            val calendar = Calendar.getInstance()
            val chipgroup:ChipGroup=binding.chipGroup
            val m=chipgroup.findViewById<Chip>(R.id.monday)
            val t=chipgroup.findViewById<Chip>(R.id.tuesday)
            val w=chipgroup.findViewById<Chip>(R.id.wednesday)
            val th=chipgroup.findViewById<Chip>(R.id.thursday)
            val f=chipgroup.findViewById<Chip>(R.id.friday)
            val sat=chipgroup.findViewById<Chip>(R.id.saturday)
            val sun=chipgroup.findViewById<Chip>(R.id.sunday)
            var selectedDate=ArrayList<Boolean>()
            selectedDate.add(m.isChecked)
            selectedDate.add(t.isChecked)
            selectedDate.add(w.isChecked)
            selectedDate.add(th.isChecked)
            selectedDate.add(f.isChecked)
            selectedDate.add(sat.isChecked)
            selectedDate.add(sun.isChecked)
           var alarmTime= createDate(selectedDate,binding.timePicker1.hour,binding.timePicker1.minute)



            Log.d("chips",""+selectedDate.toString())
//            calendar.set(
//                datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
//                timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0
//            )


            binding.okButton.setOnClickListener{

            }

            val startTime = calendar.getTimeInMillis()

            Toast.makeText(activity, binding.timePicker1.hour.toString()+" "+binding.timePicker1.minute.toString() ,Toast.LENGTH_LONG).show()
            createAlarmManager(alarmTime)

        }

        binding.cancelButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_settingsFragment_to_alarmFragment3)
        }

        return binding.root
    }
    //
    private fun createAlarmManager(alarmTime:Long){
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager

// Intent part
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.action = "FOO_ACTION"
        intent.putExtra("KEY_FOO_STRING", "Medium AlarmManager Demo")

        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

// Alarm time
        val ALARM_DELAY_IN_SECOND = 10
        val alarmTimeAtUTC = System.currentTimeMillis() + ALARM_DELAY_IN_SECOND * 1_000L
        Log.d("time",""+alarmTimeAtUTC)
// Set with system Alarm Service
// Other possible functions: setExact() / setRepeating() / setWindow(), etc
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)

    }

    private fun createDate(days:ArrayList<Boolean>, hour:Int, minute:Int): Long {
        //0=monday 1= tuesday 2= wednesday etc
        var day=days.indexOf(true)
        val calendar=Calendar.getInstance().time

        Log.d("debug",calendar.toString())
        var currDate:Int=0
        if(calendar.toString().equals("Mon"))
            currDate=0
        if(calendar.toString().equals("Tue"))
            currDate=1
        if(calendar.toString().equals("Wed"))
            currDate=2
        if(calendar.toString().equals("Thu"))
            currDate=3
        if(calendar.toString().equals("Fri"))
            currDate=4
        if(calendar.toString().equals("Sat"))
            currDate=5
        if(calendar.toString().equals("Sun"))
            currDate=6

        var offset=(day-currDate)
        Log.d("debug","offset "+offset+" ")

        var alarmDate=Date(calendar.year,calendar.month,calendar.date+offset,hour,minute)
        Log.d("debug",""+alarmDate.time)
        return alarmDate.time
    }
}