package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.secondproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        //binding?.run{
           // buttonToProfile.setOnClickListener {
               // findNavController().navigate(
                //    R.id.action_settingsFragment_to_newTLFragment,
              //      createBundle()
              //  )

            //}
        //}
    }
    companion object{
        private var binding: FragmentSettingsBinding? = null
        fun createBundle():Bundle{
                var bundle = Bundle()
                bundle.putString("TL_NAME", "Settings")
                return bundle
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}