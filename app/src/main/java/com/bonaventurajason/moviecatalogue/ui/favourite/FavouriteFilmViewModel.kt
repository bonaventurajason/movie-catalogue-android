package com.bonaventurajason.moviecatalogue.ui.favourite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource

class FavouriteFilmViewModel @ViewModelInject constructor(
    private val filmDataSource: FilmDataSource
) : ViewModel() {

    fun getFavouriteMovies() = filmDataSource.getAllFavouriteMovies()

    fun getFavouriteTVShows() = filmDataSource.getAllFavouriteTVShows()
}