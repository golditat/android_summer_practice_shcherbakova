package com.example.secondproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.secondproject.databinding.ItemTlBinding

class TLItem(
    private val binding: ItemTlBinding,
    private val glide: RequestManager,
    val onItemClick: (Int) -> Unit
):ViewHolder(binding.root) {
    private val options:RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
    private var windowItem: TL? = null

    fun onBind(tl:TL){
        windowItem = tl
        binding.run{
            tlname.text = tl.name
            tltime.text = tl.time
            glide
                .load(tl.url)
                .apply(options)
                .into(imageTL)
            root.setOnClickListener {
                onItemClick(tl.id)
            }
        }
    }
}