package com.example.secondproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.secondproject.databinding.FragmentTLListBinding

class TLListFragment : Fragment(R.layout.fragment_t_l_list){
    private var adapter: TLAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTLListBinding.bind(view)
        createNewTL()
        binding?.run{
            fab.setOnClickListener{
                Log.e("TEST", "CLICK!!!!!!!!!!!!!!!!!!!")
                findNavController().navigate(R.id.action_TLListFragment_to_newTLFragment)
            }
        }
        initAdapter()
    }
    fun createNewTL(){
        if(correct()) {
            var newTL: TL = TL(
                SingletonListObject.currentid + 1,
                arguments?.getString("NEW_TL_NAME").toString(),
                arguments?.getString("NEW_TL_TIME").toString(),
                arguments?.getString("NEW_TL_INFO").toString(),
                arguments?.getString("NEW_TL_URL").toString()
            )
            SingletonListObject.addToTlList(newTL)
        }
    }
    fun correct():Boolean{
        if((arguments?.getString("NEW_TL_NAME").toString()!= null)
            &&(arguments?.getString("NEW_TL_TIME").toString()!=null)
            && correctURL(arguments?.getString("NEW_TL_URL").toString())){
            return true
        }
        return false
    }
    fun correctURL(url:String?):Boolean{
        if(url!=null) {
            val pattern =
                "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)".toRegex(RegexOption.IGNORE_CASE)
            return pattern.matches(url)
        }
        return false
    }
    private fun initAdapter(){
        adapter = TLAdapter(SingletonListObject.list, Glide.with(this))
        binding?.rvTl?.adapter = adapter
    }

    companion object{
        private var binding: FragmentTLListBinding? = null
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