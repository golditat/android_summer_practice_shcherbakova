package com.example.secondproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.secondproject.databinding.FragmentTLListBinding

class TLListFragment : Fragment(R.layout.fragment_t_l_list){
    private var adapter: TLAdapter? = null
    private var binding:FragmentTLListBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTLListBinding.bind(view)
        binding?.textView5?.text = SingletonListObject.list.size.toString()
        binding?.run{
            fab.setOnClickListener{
                Log.e("TEST", "CLICK")
                findNavController().navigate(
                    R.id.action_TLListFragment_to_editTLFragment
                )
            }

        }
        initAdapter()
    }
    private fun initAdapter() {
        adapter = TLAdapter(SingletonListObject.list,
            Glide.with(this),
            { tl -> findNavController().navigate(R.id.action_TLListFragment_to_infoTLFragment, createBundle(tl))
            }
        )
        binding?.rvTl?.adapter = adapter
    }
    fun createBundle(id : Int) : Bundle {
        val bundle = Bundle()
        bundle.putInt("ID", id)
        return bundle
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}