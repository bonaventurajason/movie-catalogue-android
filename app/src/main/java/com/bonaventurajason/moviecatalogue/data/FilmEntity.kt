package com.bonaventurajason.moviecatalogue.data


data class FilmEntity(
    var filmId: String,
    var title: String,
    var description: String,
    var releaseDate: String,
    var genre: String,
    var creator: String,
    var rating: Double,
    var poster: Int
)