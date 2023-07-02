package com.example.secondproject

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.secondproject.databinding.ItemTlBinding

class TLItem(
    private val binding: ItemTlBinding,
    private val glide: RequestManager
):ViewHolder(binding.root) {
    fun onBind(tl:TL){
        binding.run{
            tlname.text = tl.name
            tltime.text = tl.time
            glide.load(tl.url).into(imageTL)
        }
    }
}