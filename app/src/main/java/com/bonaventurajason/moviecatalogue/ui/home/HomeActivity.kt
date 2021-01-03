package com.bonaventurajason.moviecatalogue.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.databinding.ActivityHomeBinding
import com.bonaventurajason.moviecatalogue.ui.favourite.FavouriteActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Moviecatalogueandroid)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)



        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.favourite){
            startActivity(Intent(this, FavouriteActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}