package com.example.secondproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.secondproject.databinding.FragmentNewTLBinding
import com.google.android.material.snackbar.Snackbar

class NewTLFragment : Fragment(R.layout.fragment_new_t_l){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTLBinding.bind(view)
        Snackbar.make(binding!!.root, arguments?.getString("TL_NAME").toString(),Snackbar.LENGTH_LONG ).show()
    }
    companion object{
        private var binding: FragmentNewTLBinding? = null
        fun createBundle():Bundle{
            var bundle = Bundle()
            if(correct(binding?.it1?.text.toString())){
                bundle.putString("NEW_TL_NAME", binding?.it1?.text.toString())
            }
            if(correct(binding?.it2?.text.toString())){
                bundle.putString("NEW_TL_INFO", binding?.it2?.text.toString())
            }
            return bundle
        }
        fun correct(arg:String?):Boolean{
            if(arg != null){
                return true
            }
            return false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
