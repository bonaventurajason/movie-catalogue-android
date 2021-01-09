package com.bonaventurajason.moviecatalogue.ui.favourite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bonaventurajason.moviecatalogue.databinding.ActivityFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
    }

}