package com.amvlabs.meeshodemo.adapters.viewholder

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.amvlabs.meeshodemo.databinding.*
import com.amvlabs.meeshodemo.model.ChildRecyclerViewItems
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems
import com.amvlabs.meeshodemo.model.ProductData

sealed class HomeRecyclerViewHolder(binding: ViewBinding):RecyclerView.ViewHolder(binding.root){
    class BaseLayoutHolder(private val binding:ItemBaseLayoutBinding):HomeRecyclerViewHolder(binding){
         var recyclerView = binding.baseRecyclerView
        var childViewModelAdapter = ChildViewModelAdapter()
        fun bind(items:HomeRecyclerViewItems.LayoutItems) {
            recyclerView.apply {
//                layoutManager = GridLayoutManager(binding.root.context,2,GridLayoutManager.VERTICAL,false)
                layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
                adapter = childViewModelAdapter
            }
            Log.d("TAG", "bind:${items.list.size} ")
            binding.itemTitle.text = items.title
            childViewModelAdapter.itemList = items.list
        }
    }
}
