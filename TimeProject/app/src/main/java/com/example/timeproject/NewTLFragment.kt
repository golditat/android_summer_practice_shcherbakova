package com.example.timeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.timeproject.databinding.FragmentInfoTLBinding
import com.example.timeproject.databinding.FragmentNewTLBinding

class NewTLFragment : Fragment(R.layout.fragment_new_t_l){
    private var binding: FragmentNewTLBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTLBinding.bind(view)
        binding?.run{
            buttonNewTLToInfoTL.setOnClickListener {
                findNavController().navigate(R.id.action_newTLFragment_to_infoTLFragment2)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}