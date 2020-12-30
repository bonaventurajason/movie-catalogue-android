package com.bonaventurajason.moviecatalogue.utils

import com.bonaventurajason.moviecatalogue.data.source.model.FilmResult
import com.bonaventurajason.moviecatalogue.data.source.model.Genre
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse

object DataDummy {

    fun generateDummyMovieResponse(): Resource<FilmResponse> {

        val movies = mutableListOf<FilmResult>()

        movies.add(
            FilmResult(
                "A Star is Born",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                1
            )
        )
        movies.add(
            FilmResult(
                "Alita: Battle Angel",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                2

            )
        )
        movies.add(
            FilmResult(
                "Aquaman",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                3
            )
        )
        movies.add(
            FilmResult(
                "Bohemian Rhapsody",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                4
            )
        )
        movies.add(
            FilmResult(
                "Cold Pursuit",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                5
            )
        )
        movies.add(
            FilmResult(
                "Creed II",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                6
            )
        )
        movies.add(
            FilmResult(
                "Fantastic Beasts: The Crimes of Grindelwald",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                7
            )
        )
        movies.add(
            FilmResult(
                "Glass",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                8
            )
        )
        movies.add(
            FilmResult(
                "How to Train Your Dragon: The Hidden World",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                9
            )
        )
        movies.add(
            FilmResult(
                "Avengers: Infinity War",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                10
            )
        )
        return Resource.success(FilmResponse(1,10, movies.toList(),10))
    }


    fun generateDummyTVShowResponse():Resource<FilmResponse> {

        val tvShow = mutableListOf<FilmResult>()

        tvShow.add(
            FilmResult(
                "Arrow",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                1
            )
        )
        tvShow.add(
            FilmResult(
                "Doom Patrol",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                2
            )
        )
        tvShow.add(
            FilmResult(
                "Dragon Ball",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                3
            )
        )
        tvShow.add(
            FilmResult(
                "Fairy Tail",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                4
            )
        )
        tvShow.add(
            FilmResult(
                "Family Guy",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                5
            )
        )
        tvShow.add(
            FilmResult(
                "The Flash",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                6
            )
        )
        tvShow.add(
            FilmResult(
                "Game of Thrones",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                7
            )
        )
        tvShow.add(
            FilmResult(
                "Gotham",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                8
            )
        )
        tvShow.add(
            FilmResult(
                "Grey Anatomy",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                9
            )
        )
        tvShow.add(
            FilmResult(
                "Hanna",
                "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
                10
            )
        )
        return Resource.success(FilmResponse(1,10, tvShow.toList(),10))
    }

    fun generateDummyDetailMovie() : Resource<DetailFilmResponse>{
        val genres = listOf(Genre("Drama",0), Genre("Romance",1), Genre("Music",2))
        return Resource.success(DetailFilmResponse(
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "en",
            "A Star is Born",
            "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
            "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
            "homepage",
            "2018-10-05",
            genres,
            0.75,
            "A Star is Born",
            1
        ))
    }

    fun generateDummyDetailTVShow() : Resource<DetailFilmResponse>{
        val genres = listOf(Genre("Crime",0), Genre("Drama",1), Genre("Mystery",2))
        return Resource.success(DetailFilmResponse(
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow",
            "en",
            "Arrow",
            "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
            "https://image.tmdb.org/t/p/w500/dlTTBkz2l90stPlBxSdXwb8gGsQ.jpg",
            "homepage",
            "2018-10-05",
            genres,
            0.65,
            "Heroes fall. Legends rise.",
            1
        ))
    }

}