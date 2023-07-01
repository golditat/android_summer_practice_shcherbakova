package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.secondproject.databinding.FragmentInfoTL2Binding
import com.example.secondproject.databinding.FragmentInfoTL3Binding
import com.example.secondproject.databinding.FragmentNewTLBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class InfoTL3Fragment : Fragment(R.layout.fragment_info_t_l3){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoTL3Binding.bind(view)
        binding?.run{
            buttonToNewTL.setOnClickListener {
                findNavController().navigate(R.id.action_infoTL3Fragment_to_newTLFragment,
                    createBundle()
                )
            }
        }
    }
    companion object{
        private var binding: FragmentInfoTL3Binding? = null
        fun createBundle():Bundle{
            var bundle = Bundle()
            bundle.putString("TL_NAME", "TL3")
            return bundle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}