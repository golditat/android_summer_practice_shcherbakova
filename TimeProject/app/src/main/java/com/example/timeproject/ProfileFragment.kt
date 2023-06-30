package com.example.timeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.timeproject.databinding.FragmentInfoTLBinding
import com.example.timeproject.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile){
    private var binding: FragmentProfileBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        binding?.run{
            buttonToSettings.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
            }
            buttonToTL.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_infoTLFragment2)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}