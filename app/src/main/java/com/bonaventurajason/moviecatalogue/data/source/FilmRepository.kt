package com.bonaventurajason.moviecatalogue.data.source

import com.bonaventurajason.moviecatalogue.data.source.remote.api.FilmApi
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.NO_INTERNET
import com.bonaventurajason.moviecatalogue.utils.Constant.UNKNOWN_ERROR
import com.bonaventurajason.moviecatalogue.utils.EspressoIdlingResource
import com.bonaventurajason.moviecatalogue.utils.Resource
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApi: FilmApi
) : FilmDataSource{
    override suspend fun getAllMovies(): Resource<FilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getPopularMovies()
            EspressoIdlingResource.decrement()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else{
                Resource.error(UNKNOWN_ERROR, null)
            }
        }catch (e: Exception){
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getAllTVShows(): Resource<FilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getPopularTVShows()
            EspressoIdlingResource.decrement()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else{
                Resource.error(UNKNOWN_ERROR, null)
            }
        }catch (e: Exception){
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getDetailMovies(movieId: Int): Resource<DetailFilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getDetailMovies(movieId)
            EspressoIdlingResource.decrement()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else{
                Resource.error(UNKNOWN_ERROR, null)
            }
        }catch (e: Exception){
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getDetailTVShows(tvId: Int): Resource<DetailFilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getDetailTVSHows(tvId)
            EspressoIdlingResource.decrement()
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else{
                Resource.error(UNKNOWN_ERROR, null)
            }
        }catch (e: Exception){
            Resource.error(NO_INTERNET, null)
        }
    }


}