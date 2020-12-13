package com.bonaventurajason.moviecatalogue.data.source

import com.bonaventurajason.moviecatalogue.data.source.remote.api.FilmApi
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApi: FilmApi
){
    suspend fun getAllMovies() = filmApi.getPopularMovies()
    suspend fun getAllTVShows() = filmApi.getPopularTVShows()
}