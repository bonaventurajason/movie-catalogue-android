package com.bonaventurajason.moviecatalogue.utils

import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse

fun DetailFilmResponse.toFilmEntity(type: String): FilmEntity =
    FilmEntity(
        filmId = id,
        title = title,
        backdropPath = backdropPath,
        overview = overview,
        originalLanguage = originalLanguage,
        posterPath = posterPath,
        releaseDate = releaseDate,
        genres = genres?.joinToString {
            it.name
        },
        voteAverage = voteAverage,
        tagline = tagline,
        type = type
    )