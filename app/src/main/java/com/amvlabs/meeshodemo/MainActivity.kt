package com.amvlabs.meeshodemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val action = setSupportActionBar(binding.includedToolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btmNavigationView = binding.btmNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        btmNavigationView.setupWithNavController(navController)
        btmNavigationView.selectedItemId = R.id.homeFragment2
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_menu_fav ->    Toast.makeText(this,"Favorite",Toast.LENGTH_LONG).show()
            R.id.item_menu_notif ->  Toast.makeText(this,"Notification",Toast.LENGTH_LONG).show()
            R.id.item_menu_cart ->   Toast.makeText(this,"Cart",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}