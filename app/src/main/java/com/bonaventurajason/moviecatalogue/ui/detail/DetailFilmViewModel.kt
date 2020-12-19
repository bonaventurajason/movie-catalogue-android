package com.bonaventurajason.moviecatalogue.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.MOVIE
import com.bonaventurajason.moviecatalogue.utils.Event
import com.bonaventurajason.moviecatalogue.utils.Resource
import kotlinx.coroutines.launch

class DetailFilmViewModel @ViewModelInject constructor(
    private val filmDataSource: FilmDataSource
): ViewModel(){

    private val _detailFilm = MutableLiveData<Event<Resource<DetailFilmResponse>>>()
    val detailFilm: LiveData<Event<Resource<DetailFilmResponse>>> = _detailFilm

    fun getDetailFilm(typeOfFilm: String, id: Int){
        _detailFilm.value = Event(Resource.loading(null))
        viewModelScope.launch {
            if(typeOfFilm == MOVIE){
                val response = filmDataSource.getDetailMovies(id)
                _detailFilm.value = Event(response)
            }
            else{
                val response = filmDataSource.getDetailTVShows(id)
                _detailFilm.value = Event(response)
            }
        }
    }
//
//    private suspend fun safeDetailFilmCall(typeOfFilm: String, id: Int) {
//        _detailFilm.postValue(Resource.Loading())
//        try {
//            if(isNetworkConnected()){
//                if(typeOfFilm == MOVIE){
//                    val response = filmRepository.getDetailMovies(id)
//                    _detailFilm.postValue(handleDetailFilmResponse(response))
//                }
//                else{
//                    val response = filmRepository.getDetailTVShows(id)
//                    _detailFilm.postValue(handleDetailFilmResponse(response))
//                }
//            }
//            else{
//                _detailFilm.postValue(Resource.Error(Constant.NO_INTERNET))
//            }
//        } catch (t: Throwable){
//            _detailFilm.postValue(t.message?.let { Resource.Error(it) })
//        }
//    }
//
//    private fun handleDetailFilmResponse(response: Response<DetailFilmResponse>): Resource<DetailFilmResponse>? {
//        if(response.isSuccessful){
//            response.body()?.let { resultResponse ->
//                return Resource.Success(resultResponse)
//            }
//        }
//        return Resource.Error(response.message())
//
//    }
//
//    fun refreshGetDetailFilm(typeOfFilm: String, id: Int){
//        getDetailFilm(typeOfFilm, id)
//    }


}