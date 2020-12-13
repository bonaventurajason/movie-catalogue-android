package com.bonaventurajason.moviecatalogue.ui.film

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.FilmEntity
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.model.FilmResult
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bonaventurajason.moviecatalogue.utils.DataDummy
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class FilmViewModel @ViewModelInject constructor(
    private val filmRepository: FilmRepository,
    private val connectivityManager: ConnectivityManager
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<FilmResponse>>()
    val movies: LiveData<Resource<FilmResponse>> = _movies

    private val _tvShows = MutableLiveData<Resource<FilmResponse>>()
    val tvShows: LiveData<Resource<FilmResponse>> = _tvShows

    fun getMovies() = viewModelScope.launch {
        safeMoviesCall()
    }

    fun getTvShows() = viewModelScope.launch {
        safeTVShowsCall()
    }



    private suspend fun safeMoviesCall() {
        _movies.postValue(Resource.Loading())
        try {
            if (isNetworkConnected()) {
                val response = filmRepository.getAllMovies()
                _movies.postValue(handleFilmResponse(response))
            }
            else{
                _movies.postValue(Resource.Error(Constant.NO_INTERNET))
            }
        }catch (t: Throwable){
            _movies.postValue(t.message?.let { Resource.Error(it) })
        }

    }

    private suspend fun safeTVShowsCall() {
        _tvShows.postValue(Resource.Loading())
        try {
            if (isNetworkConnected()) {
                val response = filmRepository.getAllTVShows()
                _tvShows.postValue(handleFilmResponse(response))
            }
            else{
                _tvShows.postValue(Resource.Error(Constant.NO_INTERNET))
            }
        }catch (t: Throwable){
            _tvShows.postValue(t.message?.let { Resource.Error(it) })
        }
    }


    private fun handleFilmResponse(response: Response<FilmResponse>): Resource<FilmResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())

    }




    private fun isNetworkConnected(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                networkCapabilities.hasTransport(TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false

    }
    fun refreshGetAllMovies(){
        getMovies()
    }
    fun refreshGetAllTVMovies(){
        getTvShows()
    }
}