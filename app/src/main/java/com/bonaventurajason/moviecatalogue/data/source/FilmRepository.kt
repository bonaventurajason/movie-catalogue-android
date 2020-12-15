package com.bonaventurajason.moviecatalogue.data.source

import com.bonaventurajason.moviecatalogue.data.source.remote.api.FilmApi
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApi: FilmApi
){
    suspend fun getAllMovies() = filmApi.getPopularMovies()
    suspend fun getAllTVShows() = filmApi.getPopularTVShows()

    suspend fun getDetailMovies(movieId: Int) = filmApi.getDetailMovies(movieId)
    suspend fun getDetailTVShows(tvId: Int) = filmApi.getDetailTVSHows(tvId)

}