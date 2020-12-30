package com.bonaventurajason.moviecatalogue.ui.film

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bonaventurajason.moviecatalogue.MainCoroutineRule
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
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
class FilmViewModelTest {
    private lateinit var viewModel: FilmViewModel
    private val dummyMovieResponse = DataDummy.generateDummyMovieResponse()
    private val dummyTVShowResponse = DataDummy.generateDummyTVShowResponse()

    @get:Rule
    val instantTaskRuleExecutor = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<FilmResponse>>





    @Before
    fun setup(){
        viewModel = FilmViewModel(filmRepository)
    }

    @Test
    fun getMovies(){
        val movieResponse = MutableLiveData<Resource<FilmResponse>>()
        movieResponse.value = dummyMovieResponse
        runBlocking {
            `when`(filmRepository.getAllMovies()).thenReturn(movieResponse.value)
            viewModel.getMovies()
            val dataMovie = viewModel.movies.value
            verify(filmRepository).getAllMovies()
            assertThat(dataMovie).isNotNull()
            viewModel.movies.observeForever(observer)
            verify(observer).onChanged(dummyMovieResponse)
        }
    }

    @Test
    fun getTVShows(){
        val tvShowResponse = MutableLiveData<Resource<FilmResponse>>()
        tvShowResponse.value = dummyTVShowResponse
        runBlocking {
            `when`(filmRepository.getAllTVShows()).thenReturn(tvShowResponse.value)
            viewModel.getTVShows()
            val dataTVShow = viewModel.tvShows.value
            verify(filmRepository).getAllTVShows()
            assertThat(dataTVShow).isNotNull()

            viewModel.tvShows.observeForever(observer)
            verify(observer).onChanged(dataTVShow)

        }


    }
}