package com.bonaventurajason.moviecatalogue.data.source.model

import com.google.gson.annotations.SerializedName

data class FilmResult(

	@field:SerializedName("title", alternate = ["name"])
	val title: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("id")
	val id: Int
)