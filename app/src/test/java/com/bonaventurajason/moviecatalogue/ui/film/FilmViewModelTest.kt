package com.bonaventurajason.moviecatalogue.ui.film

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @Before
    fun setUp(){
        viewModel = FilmViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)

    }

    @Test
    fun getTvShows() {
        val tvShowEntities = viewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}