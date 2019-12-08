package com.example.finalproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.finalproject.databinding.FragmentAlarmBinding
import androidx.navigation.findNavController



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AlarmFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAlarmBinding>(inflater,
            R.layout.fragment_alarm,container,false)
        binding.addAlarmButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_alarmFragment_to_settingsFragment)
        }

        return binding.root
    }


}