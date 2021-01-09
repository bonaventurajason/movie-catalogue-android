package com.bonaventurajason.moviecatalogue.ui.favourite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bonaventurajason.moviecatalogue.R

class FavouritePagerAdapter(
    private val context: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_show)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        FavouriteMovieFragment.newInstance(position)

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(
        TAB_TITLES[position])
}