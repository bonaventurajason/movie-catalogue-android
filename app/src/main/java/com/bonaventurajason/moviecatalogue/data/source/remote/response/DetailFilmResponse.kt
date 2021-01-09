package com.bonaventurajason.moviecatalogue.data.source.remote.response

import com.bonaventurajason.moviecatalogue.data.source.model.Genre
import com.google.gson.annotations.SerializedName

data class DetailFilmResponse(

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("title", alternate = ["name"])
	val title: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("release_date", alternate = ["first_air_date"])
	val releaseDate: String? = null,

	@field:SerializedName("genres")
	val genres: List<Genre>? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("tagline")
	val tagline: String? = null,

	@field:SerializedName("id")
	val id: Int,
)