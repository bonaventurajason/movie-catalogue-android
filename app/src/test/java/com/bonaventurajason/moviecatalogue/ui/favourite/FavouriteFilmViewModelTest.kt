package com.bonaventurajason.moviecatalogue.ui.favourite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
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
class FavouriteFilmViewModelTest {
    private lateinit var viewModel: FavouriteFilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FilmEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>

    @Before
    fun setUp() {
        viewModel = FavouriteFilmViewModel(filmRepository)
    }

    @Test
    fun getFavouriteMovies(){
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<FilmEntity>>()
        movies.value = dummyMovies

        runBlocking {
            `when`(filmRepository.getAllFavouriteMovies()).thenReturn(movies)
            val movieEntities = viewModel.getFavouriteMovies().value
            verify(filmRepository).getAllFavouriteMovies()
            assertThat(movieEntities).isNotNull()
            assertThat(movieEntities?.size).isEqualTo(5)
            viewModel.getFavouriteMovies().observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }

    @Test
    fun getFavouriteTVShows(){
        val dummyTVShows = pagedList
        `when`(dummyTVShows.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<FilmEntity>>()
        tvShows.value = dummyTVShows

        runBlocking {
            `when`(filmRepository.getAllFavouriteTVShows()).thenReturn(tvShows)
            val tvShowEntities = viewModel.getFavouriteTVShows().value
            verify(filmRepository).getAllFavouriteTVShows()
            assertThat(tvShowEntities).isNotNull()
            assertThat(tvShowEntities?.size).isEqualTo(5)
            viewModel.getFavouriteTVShows().observeForever(observer)
            verify(observer).onChanged(dummyTVShows)
        }
    }
}