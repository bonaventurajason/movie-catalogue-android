package com.bonaventurajason.moviecatalogue.ui.film

import androidx.lifecycle.ViewModel
import com.bonaventurajason.moviecatalogue.data.FilmEntity
import com.bonaventurajason.moviecatalogue.utils.DataDummy

class FilmViewModel : ViewModel() {

    fun getMovies(): List<FilmEntity> = DataDummy.generateDummyMovies()

    fun getTvShows(): List<FilmEntity> = DataDummy.generateDummyTVShow()
}