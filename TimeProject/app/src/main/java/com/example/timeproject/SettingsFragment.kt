package com.example.timeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.timeproject.databinding.FragmentInfoTLBinding
import com.example.timeproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings){
    private var binding: FragmentSettingsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding?.run{
            buttonToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_settingsFragment_to_profileFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}