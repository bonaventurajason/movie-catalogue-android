package com.bonaventurajason.moviecatalogue.ui.detail

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bonaventurajason.moviecatalogue.utils.Constant.MOVIE
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailFilmViewModel @ViewModelInject constructor(
    private val filmRepository: FilmRepository,
    private val connectivityManager: ConnectivityManager
): ViewModel(){

    private val _detailFilm = MutableLiveData<Resource<DetailFilmResponse>>()
    val detailFilm: LiveData<Resource<DetailFilmResponse>> = _detailFilm

    fun getDetailFilm(typeOfFilm: String, id: Int) = viewModelScope.launch {
        safeDetailFilmCall(typeOfFilm, id)
    }

    private suspend fun safeDetailFilmCall(typeOfFilm: String, id: Int) {
        _detailFilm.postValue(Resource.Loading())
        try {
            if(isNetworkConnected()){
                if(typeOfFilm == MOVIE){
                    val response = filmRepository.getDetailMovies(id)
                    _detailFilm.postValue(handleDetailFilmResponse(response))
                }
                else{
                    val response = filmRepository.getDetailTVShows(id)
                    _detailFilm.postValue(handleDetailFilmResponse(response))
                }
            }
            else{
                _detailFilm.postValue(Resource.Error(Constant.NO_INTERNET))
            }
        } catch (t: Throwable){
            _detailFilm.postValue(t.message?.let { Resource.Error(it) })
        }
    }

    private fun handleDetailFilmResponse(response: Response<DetailFilmResponse>): Resource<DetailFilmResponse>? {
        if(response.isSuccessful){
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
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
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

    fun refreshGetDetailFilm(typeOfFilm: String, id: Int){
        getDetailFilm(typeOfFilm, id)
    }


}