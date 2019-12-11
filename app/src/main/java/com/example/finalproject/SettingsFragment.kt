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
import kotlinx.android.synthetic.main.fragment_settings.view.*

import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*

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
            val chips=binding.chipGroup.checkedChipId
            Log.d("chips",""+chips)
//            calendar.set(
//                datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
//                timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0
//            )

            binding.okButton.setOnClickListener{

            }

            val startTime = calendar.getTimeInMillis()

            Toast.makeText(activity, binding.timePicker1.hour.toString()+" "+binding.timePicker1.minute.toString() ,Toast.LENGTH_LONG).show()
            createAlarmManager()

        }

        binding.cancelButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_settingsFragment_to_alarmFragment3)
        }

        return binding.root
    }
    //
    private fun createAlarmManager(){
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
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTimeAtUTC, pendingIntent)

    }
}