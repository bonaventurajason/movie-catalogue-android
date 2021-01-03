package com.bonaventurajason.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Resource

interface FilmDataSource {

    suspend fun getAllMovies(): Resource<FilmResponse>

    suspend fun getAllTVShows(): Resource<FilmResponse>

    suspend fun getDetailMovies(movieId: Int): Resource<DetailFilmResponse>

    suspend fun getDetailTVShows(tvId: Int): Resource<DetailFilmResponse>


    suspend fun insertFavouriteFilm(filmEntity: FilmEntity)
    suspend fun deleteFavouriteFilm(title: String)

    fun getAllFavouriteMovies() : LiveData<List<FilmEntity>>
    fun getAllFavouriteTVShows() : LiveData<List<FilmEntity>>
    fun checkFavouriteFilms(title: String) : LiveData<FilmEntity>




}