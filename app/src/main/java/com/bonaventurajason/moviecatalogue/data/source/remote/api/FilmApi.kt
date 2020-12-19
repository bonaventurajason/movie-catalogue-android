package com.bonaventurajason.moviecatalogue.data.source.remote.api


import com.bonaventurajason.moviecatalogue.BuildConfig
import com.bonaventurajason.moviecatalogue.data.source.remote.response.DetailFilmResponse
import com.bonaventurajason.moviecatalogue.data.source.remote.response.FilmResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_TOKEN
    ) : Response<FilmResponse>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_TOKEN
    ) : Response<FilmResponse>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_TOKEN
    ) : Response<DetailFilmResponse>

    @GET("tv/{tv_id}")
    suspend fun getDetailTVSHows(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_TOKEN
    ) : Response<DetailFilmResponse>
}