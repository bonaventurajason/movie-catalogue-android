package com.bonaventurajason.moviecatalogue.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity

@Database(
    entities = [FilmEntity::class],
    version = 1,
    exportSchema = false
)

abstract class FavouriteDatabase : RoomDatabase(){

    abstract fun getFavouriteDao():FavouriteDAO
}