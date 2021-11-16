package com.ta.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ta.recyclerviewdemo.databinding.ItemListBinding

class ListAdapter(
    private val dataList: ArrayList<String>,
    private val itemClickListener: ItemClickListener
): RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    companion object {
        val TAG = "Rango"
    }

    inner class ItemViewHolder(val itemBinding: ItemListBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemListBinding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewHolder = ItemViewHolder(binding)
        Log.d(TAG, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        Log.d(TAG, "onBindViewHolder: $holder")

        val item = dataList[position]

        holder.itemBinding.tvContent.text = item

        holder.itemBinding.root.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onViewAttachedToWindow(holder: ItemViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d(TAG, "onViewAttachedToWindow: $holder")
    }

    override fun onViewDetachedFromWindow(holder: ItemViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.d(TAG, "onViewDetachedFromWindow: $holder")
    }

    override fun onViewRecycled(holder: ItemViewHolder) {
        super.onViewRecycled(holder)
        Log.d(TAG, "onViewRecycled: $holder")
    }

}

interface ItemClickListener {
    fun onItemClick(position: Int)
}