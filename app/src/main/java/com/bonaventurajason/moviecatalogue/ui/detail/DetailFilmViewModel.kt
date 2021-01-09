package com.bonaventurajason.moviecatalogue.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.MOVIE
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch

class DetailFilmViewModel @ViewModelInject constructor(
    private val filmDataSource: FilmDataSource
) : ViewModel() {

    private val _detailFilm = MutableLiveData<Resource<DetailFilmResponse>>()
    val detailFilm: LiveData<Resource<DetailFilmResponse>> = _detailFilm

    private val filmEntity = MutableLiveData<FilmEntity>()

    fun setFilmEntity(filmEntity: FilmEntity) {
        this.filmEntity.value = filmEntity
    }

    fun getDetailFilm(typeOfFilm: String, id: Int) {
        _detailFilm.value = Resource.loading(null)
        viewModelScope.launch {
            if (typeOfFilm == MOVIE) {
                val response = filmDataSource.getDetailMovies(id)
                _detailFilm.value = response
            } else {
                val response = filmDataSource.getDetailTVShows(id)
                _detailFilm.value = response
            }
        }
    }

    fun checkFavouriteFilm(title: String) = filmDataSource.checkFavouriteFilms(title)

    fun insertFavouriteFilm() = viewModelScope.launch {
        val film = filmEntity.value
        if (film != null) {
            filmDataSource.insertFavouriteFilm(film)
        }

    }

    fun deleteFavouriteFilm(title: String) = viewModelScope.launch {
        filmDataSource.deleteFavouriteFilm(title)

    }


}