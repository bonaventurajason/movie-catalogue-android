package com.bonaventurajason.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.utils.Constant

@Dao
interface FavouriteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(filmEntity: FilmEntity)

    @Query("DELETE FROM favouritemovies WHERE title = :title")
    suspend fun deleteFilm(title: String)

    @Query("SELECT * from favouritemovies WHERE type = :type")
    fun getAllMovies(type: String = Constant.MOVIE) : LiveData<List<FilmEntity>>

    @Query("SELECT * from favouritemovies WHERE type = :type")
    fun getAllTVShows(type: String = Constant.TV_SHOW) : LiveData<List<FilmEntity>>

    @Query("SELECT * from favouritemovies WHERE title = :title")
    fun checkFavouriteFilm(title: String) : LiveData<FilmEntity>








}