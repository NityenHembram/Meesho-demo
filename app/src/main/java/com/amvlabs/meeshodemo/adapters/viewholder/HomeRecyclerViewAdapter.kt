package com.amvlabs.meeshodemo.adapters.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.meeshodemo.R
import com.amvlabs.meeshodemo.databinding.ItemBestSellerBinding
import com.amvlabs.meeshodemo.databinding.ItemCategoriesBinding
import com.amvlabs.meeshodemo.databinding.ItemOfferBannerBinding
import com.amvlabs.meeshodemo.databinding.ItemProductBinding
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    var items = listOf<HomeRecyclerViewItems>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {

        return when (viewType) {
            R.layout.item_product -> HomeRecyclerViewHolder.ProductsViewHolder(
                ItemProductBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_categories -> HomeRecyclerViewHolder.CategoryViewHolder(
                ItemCategoriesBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_offer_banner -> HomeRecyclerViewHolder.OfferBannerViewHolder(
                ItemOfferBannerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_best_seller -> HomeRecyclerViewHolder.BestSellerViewHolder(
                ItemBestSellerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {

        when (holder) {
            is HomeRecyclerViewHolder.BestSellerViewHolder -> holder.bind(items[position] as HomeRecyclerViewItems.BestSellers)
            is HomeRecyclerViewHolder.CategoryViewHolder -> holder.bind(items[position] as HomeRecyclerViewItems.Category)
            is HomeRecyclerViewHolder.OfferBannerViewHolder -> holder.bind(items[position] as HomeRecyclerViewItems.Offers)
            is HomeRecyclerViewHolder.ProductsViewHolder -> holder.bind(items[position] as HomeRecyclerViewItems.Products)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeRecyclerViewItems.Products -> R.layout.item_product
            is HomeRecyclerViewItems.Category -> R.layout.item_categories
            is HomeRecyclerViewItems.Offers -> R.layout.item_offer_banner
            is HomeRecyclerViewItems.BestSellers -> R.layout.item_best_seller
        }

    }
}