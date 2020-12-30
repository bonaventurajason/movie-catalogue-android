package com.bonaventurajason.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bonaventurajason.moviecatalogue.MainCoroutineRule
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.utils.Constant.MOVIE
import com.bonaventurajason.moviecatalogue.utils.Constant.TV_SHOW
import com.bonaventurajason.moviecatalogue.utils.DataDummy
import com.bonaventurajason.moviecatalogue.utils.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {
    private lateinit var  viewModel: DetailFilmViewModel
    private val dummyDetailMovieResponse = DataDummy.generateDummyDetailMovie()
    private val dummyDetailTVShowResponse = DataDummy.generateDummyDetailTVShow()

    @get:Rule
    var instantTaskRuleExecutor = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<DetailFilmResponse>>


    @Before
    fun setup(){
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getDetailMovie(){
        val movieDetailResponse = MutableLiveData<Resource<DetailFilmResponse>>()
        movieDetailResponse.value = dummyDetailMovieResponse
        runBlocking {
            `when`(filmRepository.getDetailMovies(0)).thenReturn(movieDetailResponse.value)
            viewModel.getDetailFilm(MOVIE, 0)
            val dataDetailMovie = viewModel.detailFilm.value
            verify(filmRepository).getDetailMovies(0)
            assertThat(dataDetailMovie).isNotNull()
            viewModel.detailFilm.observeForever(observer)
            verify(observer).onChanged(dummyDetailMovieResponse)

        }

    }

    @Test
    fun getDetailTVShow() {
        val tvShowDetailResponse = MutableLiveData<Resource<DetailFilmResponse>>()
        tvShowDetailResponse.value = dummyDetailTVShowResponse
        runBlocking {
            `when`(filmRepository.getDetailTVShows(0)).thenReturn(tvShowDetailResponse.value)
            viewModel.getDetailFilm(TV_SHOW, 0)
            val dataDetailTVShow = viewModel.detailFilm.value
            verify(filmRepository).getDetailTVShows(0)
            assertThat(dataDetailTVShow).isNotNull()
            viewModel.detailFilm.observeForever(observer)
            verify(observer).onChanged(dummyDetailTVShowResponse)
        }
    }
}