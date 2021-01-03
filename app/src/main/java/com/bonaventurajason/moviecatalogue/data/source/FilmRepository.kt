package com.bonaventurajason.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.data.source.local.room.FavouriteDAO
import com.bonaventurajason.moviecatalogue.data.source.remote.api.FilmApi
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.NO_INTERNET
import com.bonaventurajason.moviecatalogue.utils.Constant.UNKNOWN_ERROR
import com.bonaventurajason.moviecatalogue.utils.EspressoIdlingResource
import com.bonaventurajason.moviecatalogue.utils.Resource
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val filmApi: FilmApi,
    private val favouriteDAO: FavouriteDAO
) : FilmDataSource {
    override suspend fun getAllMovies(): Resource<FilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getPopularMovies()
            EspressoIdlingResource.decrement()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else {
                Resource.error(UNKNOWN_ERROR, null)
            }
        } catch (e: Exception) {
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getAllTVShows(): Resource<FilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getPopularTVShows()
            EspressoIdlingResource.decrement()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else {
                Resource.error(UNKNOWN_ERROR, null)
            }
        } catch (e: Exception) {
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getDetailMovies(movieId: Int): Resource<DetailFilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getDetailMovies(movieId)
            EspressoIdlingResource.decrement()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else {
                Resource.error(UNKNOWN_ERROR, null)
            }
        } catch (e: Exception) {
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun getDetailTVShows(tvId: Int): Resource<DetailFilmResponse> {
        EspressoIdlingResource.increment()
        return try {
            val response = filmApi.getDetailTVSHows(tvId)
            EspressoIdlingResource.decrement()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error(UNKNOWN_ERROR, null)
            } else {
                Resource.error(UNKNOWN_ERROR, null)
            }
        } catch (e: Exception) {
            Resource.error(NO_INTERNET, null)
        }
    }

    override suspend fun insertFavouriteFilm(filmEntity: FilmEntity) {
        favouriteDAO.insertFilm(filmEntity)
    }

    override suspend fun deleteFavouriteFilm(title: String) {
        favouriteDAO.deleteFilm(title)
    }


    override fun getAllFavouriteMovies(): LiveData<List<FilmEntity>> {
        return favouriteDAO.getAllMovies()
    }

    override fun getAllFavouriteTVShows(): LiveData<List<FilmEntity>> {
        return favouriteDAO.getAllTVShows()
    }

    override fun checkFavouriteFilms(title: String): LiveData<FilmEntity> {
        return favouriteDAO.checkFavouriteFilm(title)
    }


}