package com.bonaventurajason.moviecatalogue.ui.film

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Event
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch

class FilmViewModel @ViewModelInject constructor(
    private val filmDataSource: FilmDataSource
) : ViewModel() {

    private val _movies = MutableLiveData<Event<Resource<FilmResponse>>>()
    val movies: LiveData<Event<Resource<FilmResponse>>> = _movies

    private val _tvShows = MutableLiveData<Event<Resource<FilmResponse>>>()
    val tvShows: LiveData<Event<Resource<FilmResponse>>> = _tvShows

    fun getMovies(){
        _movies.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = filmDataSource.getAllMovies()
            _movies.value = Event(response)
        }
    }

    fun getTVShows(){
        _tvShows.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = filmDataSource.getAllTVShows()
            _tvShows.value = Event(response)
        }
    }

//    fun getMovies() = viewModelScope.launch {
//        safeMoviesCall()
//    }
//
//    fun getTvShows() = viewModelScope.launch {
//        safeTVShowsCall()
//    }



//    private suspend fun safeMoviesCall() {
//        _movies.postValue(Resource.Loading())
//        try {
//            if (isNetworkConnected()) {
//                val response = filmRepository.getAllMovies()
//                _movies.postValue(handleFilmResponse(response))
//            }
//            else{
//                _movies.postValue(Resource.Error(Constant.NO_INTERNET))
//            }
//        }catch (t: Throwable){
//            _movies.postValue(t.message?.let { Resource.Error(it) })
//        }
//
//    }
//
//    private suspend fun safeTVShowsCall() {
//        _tvShows.postValue(Resource.Loading())
//        try {
//            if (isNetworkConnected()) {
//                val response = filmRepository.getAllTVShows()
//                _tvShows.postValue(handleFilmResponse(response))
//            }
//            else{
//                _tvShows.postValue(Resource.Error(Constant.NO_INTERNET))
//            }
//        }catch (t: Throwable){
//            _tvShows.postValue(t.message?.let { Resource.Error(it) })
//        }
//    }
//
//
//    private fun handleFilmResponse(response: Response<FilmResponse>): Resource<FilmResponse> {
//        if (response.isSuccessful) {
//            response.body()?.let { resultResponse ->
//                return Resource.Success(resultResponse)
//            }
//        }
//        return Resource.Error(response.message())
//
//    }
//
//    fun refreshGetAllMovies(){
//        getMovies()
//    }
//    fun refreshGetAllTVMovies(){
//        getTvShows()
//    }
}