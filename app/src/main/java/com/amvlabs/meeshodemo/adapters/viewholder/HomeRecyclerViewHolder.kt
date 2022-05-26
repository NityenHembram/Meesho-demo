package com.amvlabs.meeshodemo.adapters.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.amvlabs.meeshodemo.databinding.ItemBestSellerBinding
import com.amvlabs.meeshodemo.databinding.ItemCategoriesBinding
import com.amvlabs.meeshodemo.databinding.ItemOfferBannerBinding
import com.amvlabs.meeshodemo.databinding.ItemProductBinding
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems

sealed class HomeRecyclerViewHolder(binding: ViewBinding):RecyclerView.ViewHolder(binding.root){
    class CategoryViewHolder(private val binding:ItemCategoriesBinding):HomeRecyclerViewHolder(binding){
        fun bind(category: HomeRecyclerViewItems.Category) {}
    }
    class OfferBannerViewHolder(private val binding:ItemOfferBannerBinding):HomeRecyclerViewHolder(binding){
        fun bind(offers: HomeRecyclerViewItems.Offers) {}
    }
    class BestSellerViewHolder(private val binding:ItemBestSellerBinding):HomeRecyclerViewHolder(binding){
        fun bind(bestSellers: HomeRecyclerViewItems.BestSellers) {}
    }
    class ProductsViewHolder(private val binding:ItemProductBinding):HomeRecyclerViewHolder(binding){
        fun bind(products: HomeRecyclerViewItems.Products) {
            products.products.forEach{
                binding.productName.text = it.title
            }

        }
    }

}
