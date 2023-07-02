package com.example.secondproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.secondproject.databinding.ItemTlBinding

class TLAdapter(
    private var list:List<TL>,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<TLItem>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): TLItem = TLItem(
            ItemTlBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: TLItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}