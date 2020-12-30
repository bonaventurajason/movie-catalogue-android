package com.bonaventurajason.moviecatalogue.ui.film

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch

class FilmViewModel @ViewModelInject constructor(
    private val filmDataSource: FilmDataSource
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<FilmResponse>>()
    val movies: LiveData<Resource<FilmResponse>> = _movies

    private val _tvShows = MutableLiveData<Resource<FilmResponse>>()
    val tvShows: LiveData<Resource<FilmResponse>> = _tvShows

    fun getMovies(){
        _movies.value = Resource.loading(null)
        viewModelScope.launch {
            val response = filmDataSource.getAllMovies()
            _movies.value = response
        }
    }

    fun getTVShows(){
        _tvShows.value = Resource.loading(null)
        viewModelScope.launch {
            val response = filmDataSource.getAllTVShows()
            _tvShows.value = response
        }
    }
}