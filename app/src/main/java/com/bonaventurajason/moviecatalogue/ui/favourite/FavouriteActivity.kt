package com.bonaventurajason.moviecatalogue.ui.favourite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.databinding.ActivityFavouriteBinding
import com.bonaventurajason.moviecatalogue.ui.home.SectionsPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
@AndroidEntryPoint
class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)

        val favouritePagerAdapter = FavouritePagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = favouritePagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0f
    }
}