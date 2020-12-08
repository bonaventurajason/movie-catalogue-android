package com.bonaventurajason.moviecatalogue.ui.detail

import com.bonaventurajason.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel

    private val dummyFilm = DataDummy.generateDummyMovies()[0]
    private val dummyFilmId = dummyFilm.filmId


    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        viewModel.setSelectedFilm(dummyFilmId)
    }

    @Test
    fun getFilm() {
        viewModel.setSelectedFilm(dummyFilm.filmId)
        val filmEntity = viewModel.getFilm()
        assertNotNull(filmEntity)
        assertEquals(dummyFilm.filmId, filmEntity.filmId)
        assertEquals(dummyFilm.title, filmEntity.title)
        assertEquals(dummyFilm.poster, filmEntity.poster)
        assertEquals(dummyFilm.creator, filmEntity.creator)
        assertEquals(dummyFilm.description, filmEntity.description)
        assertEquals(dummyFilm.genre, filmEntity.genre)
        assertEquals(dummyFilm.releaseDate, filmEntity.releaseDate)
        assertEquals(dummyFilm.rating, filmEntity.rating, 0.001)


    }
}