package com.bonaventurajason.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bonaventurajason.moviecatalogue.MainCoroutineRule
import com.bonaventurajason.moviecatalogue.data.source.FakeFilmRepository
import com.bonaventurajason.moviecatalogue.utils.Constant.MOVIE
import com.bonaventurajason.moviecatalogue.utils.Constant.TV_SHOW
import com.bonaventurajason.moviecatalogue.utils.Status
import com.bonaventurajason.moviecatalogue.utils.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailFilmViewModelTest {

    private lateinit var  viewModel: DetailFilmViewModel

    @get:Rule
    var instantTaskRuleExecutor = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    @Before
    fun setup(){
        viewModel = DetailFilmViewModel(FakeFilmRepository())
    }

    @Test
    fun getDetailMovie(){
        viewModel.getDetailFilm(MOVIE, 0)
        val value = viewModel.detailFilm.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }

    @Test
    fun getDetailTVShow(){
        viewModel.getDetailFilm(TV_SHOW, 0)
        val value = viewModel.detailFilm.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }
}