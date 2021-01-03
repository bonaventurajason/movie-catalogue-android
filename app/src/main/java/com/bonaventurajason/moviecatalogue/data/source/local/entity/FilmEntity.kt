package com.bonaventurajason.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bonaventurajason.moviecatalogue.data.source.model.Genre
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favouritemovies")
data class FilmEntity(
    var filmId: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String?,

    @ColumnInfo(name = "posterPath")
    var posterPath: String?,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String?,

    @ColumnInfo(name = "genres")
    var genres: String?,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double?,

    @ColumnInfo(name = "tagline")
    var tagline: String?,

    @ColumnInfo(name = "type")
    var type: String
) : Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}