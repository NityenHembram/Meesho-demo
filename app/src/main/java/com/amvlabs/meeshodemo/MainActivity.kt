package com.amvlabs.meeshodemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.meeshodemo.adapters.viewholder.HomeRecyclerViewAdapter
import com.amvlabs.meeshodemo.databinding.ActivityMainBinding
import com.amvlabs.meeshodemo.model.HomeRecyclerViewItems
import com.amvlabs.meeshodemo.utils.ParseJsonFile
import com.amvlabs.meeshodemo.viewmodel.MyViewModel
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var homeRecyclerViewAdapter  = HomeRecyclerViewAdapter()
    lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application))[MyViewModel::class.java]

        val action = setSupportActionBar(binding.includedToolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.btmNav.selectedItemId = R.id.item_home

      viewModel.getAllItems()




        viewModel.homeListItems.observe(this){
           it.forEach{h ->
               val a = h as HomeRecyclerViewItems.Products
               a.products.forEach{p ->
                   Log.d("TAG", "onCreate: ${p.title}")
               }
           }
            homeRecyclerViewAdapter.items = it
        }

        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = homeRecyclerViewAdapter
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}