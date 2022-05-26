package com.amvlabs.meeshodemo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems
import com.amvlabs.meeshodemo.model.Product
import com.amvlabs.meeshodemo.utils.ParseJsonFile
import org.json.JSONObject

class MyViewModel(application: Application):AndroidViewModel(application) {
    val ctx = application
    val parseJsonFile = ParseJsonFile()

    private val _homeListItems = MutableLiveData<List<HomeRecyclerViewItems>>()
    val homeListItems:LiveData<List<HomeRecyclerViewItems>>
        get() = _homeListItems


    fun getAllItems(){
        val product = mutableListOf<HomeRecyclerViewItems>()
        val prod = mutableListOf<Product>()
        val products = parseJsonFile.loadProducts(ctx)
        val jsonObject = JSONObject(products!!)

        val spanSize = jsonObject.get("spansize")
        val title = jsonObject.get("title")
        val productArray = jsonObject.getJSONArray("products")
        for (i in 0 until productArray.length()){
            val name = productArray.getJSONObject(i).get("title")
            val image = productArray.getJSONObject(i).get("image")
            val description = productArray.getJSONObject(i).get("description")
            val price = productArray.getJSONObject(i).get("price")
            val rating = productArray.getJSONObject(i).get("rating")
            val p = Product(description.toString(),image.toString(), price.toString() ,rating.toString(),name.toString())
            prod.add(p)
        }
        product.add(HomeRecyclerViewItems.Products(prod,spanSize.toString(),title.toString()))
        _homeListItems.postValue(product)

    }


}