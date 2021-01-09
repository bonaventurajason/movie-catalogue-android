package com.bonaventurajason.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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


    override fun getAllFavouriteMovies(): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(favouriteDAO.getAllMovies(), config).build()
    }

    override fun getAllFavouriteTVShows(): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(favouriteDAO.getAllTVShows(), config).build()
    }

    override fun checkFavouriteFilms(title: String): LiveData<FilmEntity> {
        return favouriteDAO.checkFavouriteFilm(title)
    }


}