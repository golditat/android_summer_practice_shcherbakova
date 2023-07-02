package com.example.secondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.secondproject.databinding.FragmentEditTLBinding

class EditTLFragment : Fragment(R.layout.fragment_edit_t_l){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditTLBinding.bind(view)
        binding?.run{
            buttonNewTLToInfoTL.setOnClickListener {
                    createNewTL()
                    findNavController().navigate(
                        R.id.action_editTLFragment_to_TLListFragment
                    )

            }
        }
    }
    fun createNewTL():Boolean{
        if(correct()) {
            var newTL: TL = TL(
                SingletonListObject.currentid + 1,
                binding?.it1?.text.toString(),
                binding?.it2?.text.toString(),
                binding?.it3?.text.toString(),
                binding?.it4?.text.toString()
            )
            SingletonListObject.list.add(newTL)
            return true
        }
        return false
    }

    companion object{
        private var binding: FragmentEditTLBinding? = null
        fun createBundle():Bundle{
            var bundle = Bundle()
            return bundle
        }

        fun correctURL(url:String?):Boolean{
            if(url!=null) {
                val imageRegex = Regex("""\bhttps?://\S+\.(?:png|jpe?g|gif|jpeg)\b""")
                return imageRegex.matches(url)
            }
            return false
        }

        fun correct():Boolean{
            var url:String =binding?.it4?.text.toString()
            if((binding?.it1?.text.toString()!= null)
                    && (binding?.it2?.text.toString() != null)
                    && correctURL(url)
            ){
                return true
            }
            binding?.textView6?.text = "Mistake"
            return false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
