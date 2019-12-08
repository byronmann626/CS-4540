package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.finalproject.databinding.FragmentSettingsBinding
import androidx.navigation.findNavController


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
        }
        binding.cancelButton.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_settingsFragment_to_alarmFragment3)
        }

        return binding.root
    }


}
