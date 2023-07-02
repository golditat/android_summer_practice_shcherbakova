package com.example.secondproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.secondproject.databinding.FragmentInfoTLBinding

class InfoTLFragment : Fragment(R.layout.fragment_info_t_l){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoTLBinding.bind(view)
        val iv:ImageView? = binding?.imageView
        binding?.run{
            var bundle:Bundle? = requireActivity().intent.extras
            textViewInfoTL.text = SingletonListObject.list.get(bundle!!.getInt("ID")).name
            textView2.text = SingletonListObject.list.get(bundle!!.getInt("ID")).time
            textView.text = SingletonListObject.list.get(bundle!!.getInt("ID")).info
            Glide.with(root)
                .load(SingletonListObject.list.get(bundle!!.getInt("ID")).url)
                .into(imageView)
            buttonToNewTL.setOnClickListener {
                findNavController().navigate(R.id.action_infoTLFragment_to_editTLFragment,
                    createBundle()
                )
            }
            buttonTOTLList.setOnClickListener {
                findNavController().navigate(R.id.action_infoTLFragment_to_TLListFragment,
                    createBundle()
                )
            }
        }
    }
    companion object{
        private var binding: FragmentInfoTLBinding? = null
        fun createBundle():Bundle{
            var bundle = Bundle()
            bundle.putString("TL_NAME", "TL")
            return bundle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}