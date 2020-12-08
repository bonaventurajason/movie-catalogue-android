package com.bonaventurajason.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.bonaventurajason.moviecatalogue.data.FilmEntity
import com.bonaventurajason.moviecatalogue.utils.DataDummy

class DetailFilmViewModel : ViewModel(){

    private lateinit var filmId : String

    fun setSelectedFilm(filmId : String){
        this.filmId = filmId
    }

    fun getFilm(): FilmEntity{
        lateinit var film: FilmEntity

        if(filmId.contains("m")){
            val moviesEntities = DataDummy.generateDummyMovies()
            for(filmEntity in moviesEntities){
                if(filmEntity.filmId == filmId){
                    film = filmEntity
                }
            }
            return film
        }
        else{
            val tvShowsEntities = DataDummy.generateDummyTVShow()
            for(filmEntity in tvShowsEntities){
                if(filmEntity.filmId == filmId){
                    film = filmEntity
                }
            }
            return film
        }
    }


}