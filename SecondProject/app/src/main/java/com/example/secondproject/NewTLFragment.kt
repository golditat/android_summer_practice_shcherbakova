package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.secondproject.databinding.FragmentNewTLBinding

class NewTLFragment : Fragment(R.layout.fragment_new_t_l){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTLBinding.bind(view)
        binding?.run{
            findNavController().navigate(R.id.action_newTLFragment_to_TLListFragment,
                   createBundle()
            )
        }
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
            if(correct(binding?.it3?.text.toString())){
                bundle.putString("NEW_TL_TIME", binding?.it3?.text.toString())
            }
            if(correct(binding?.it4?.text.toString())){
                bundle.putString("NEW_TL_URL", binding?.it4?.text.toString())
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
