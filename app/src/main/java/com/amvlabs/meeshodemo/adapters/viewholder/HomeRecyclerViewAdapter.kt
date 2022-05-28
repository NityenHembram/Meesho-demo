package com.amvlabs.meeshodemo.adapters.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.meeshodemo.R
import com.amvlabs.meeshodemo.databinding.*
import com.amvlabs.meeshodemo.model.ChildRecyclerViewItems
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    var items = listOf<HomeRecyclerViewItems>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        return when (viewType) {
            R.layout.item_base_layout -> HomeRecyclerViewHolder.BaseLayoutHolder(
                ItemBaseLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }
    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        when (holder) {
            is HomeRecyclerViewHolder.BaseLayoutHolder -> holder.bind(items[position] as HomeRecyclerViewItems.LayoutItems)
        }
    }
    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
             is HomeRecyclerViewItems.LayoutItems -> R.layout.item_base_layout
//            is HomeRecyclerViewItems.ViewPagerLayoutItem ->
        }
    }

}