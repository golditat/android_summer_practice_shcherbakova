package com.example.timeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.timeproject.databinding.FragmentInfoTLBinding

class InfoTLFragment : Fragment(R.layout.fragment_info_t_l){
    private var binding: FragmentInfoTLBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoTLBinding.bind(view)
        binding?.run{
            buttonToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_infoTLFragment2_to_profileFragment)
            }
            buttonToNewTL.setOnClickListener {
                findNavController().navigate(R.id.action_infoTLFragment2_to_newTLFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}