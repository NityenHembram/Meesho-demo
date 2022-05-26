package com.amvlabs.meeshodemo.model

sealed class HomeRecyclerViewItems {
    class Category(val image:String,val category_name:String):HomeRecyclerViewItems()
    data class BestSellers(val image:String,val name:String,val price:String):HomeRecyclerViewItems()
    data class Offers(val image:String):HomeRecyclerViewItems()
    data class Products(
        val products: List<Product>,
        val spansize: String,
        val title: String
    ):HomeRecyclerViewItems()
}