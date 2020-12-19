package com.bonaventurajason.moviecatalogue.ui.film

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bonaventurajason.moviecatalogue.MainCoroutineRule
import com.bonaventurajason.moviecatalogue.data.source.FakeFilmRepository
import com.bonaventurajason.moviecatalogue.utils.Status
import com.bonaventurajason.moviecatalogue.utils.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantTaskRuleExecutor = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup(){
        viewModel = FilmViewModel(FakeFilmRepository())
    }

    @Test
    fun getMovies(){
        viewModel.getMovies()
        val value = viewModel.movies.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }

    @Test
    fun getTVShows(){
        viewModel.getTVShows()
        val value = viewModel.tvShows.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)

    }
}