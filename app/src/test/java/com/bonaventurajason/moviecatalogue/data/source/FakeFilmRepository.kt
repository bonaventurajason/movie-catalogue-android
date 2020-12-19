package com.bonaventurajason.moviecatalogue.data.source

import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.NO_INTERNET
import com.bonaventurajason.moviecatalogue.utils.Resource

class FakeFilmRepository : FilmDataSource {

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getAllMovies(): Resource<FilmResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error(NO_INTERNET, null)
        } else {
            Resource.success(FilmResponse(0,0, listOf(), 0))
        }
    }

    override suspend fun getAllTVShows(): Resource<FilmResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error(NO_INTERNET, null)
        } else {
            Resource.success(FilmResponse(0,0, listOf(), 0))
        }
    }

    override suspend fun getDetailMovies(movieId: Int): Resource<DetailFilmResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error(NO_INTERNET, null)
        } else {
            Resource.success(
                DetailFilmResponse(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf(),
                    0.0,
                    "",
                    0
                )
            )
        }
    }

    override suspend fun getDetailTVShows(tvId: Int): Resource<DetailFilmResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error(NO_INTERNET, null)
        } else {
            Resource.success(
                DetailFilmResponse(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf(),
                    0.0,
                    "",
                    0
                )
            )
        }
    }

}