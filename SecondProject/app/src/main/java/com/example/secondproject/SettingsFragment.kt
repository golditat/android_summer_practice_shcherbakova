package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.secondproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding?.run{
            button2.setOnClickListener {

                findNavController().navigate(
                 R.id.action_settingsFragment_to_profileFragment,
                    createBundle()
                )

            }
        }
    }
    companion object{
        private var binding: FragmentSettingsBinding? = null
        fun createBundle():Bundle{
            var bundle = Bundle()
            bundle.putString("PROFILE_NAME", binding?.it1?.text.toString())
            bundle.putString("PROFILE_AGE", binding?.it2?.text.toString())
            return bundle
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}