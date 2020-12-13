package com.bonaventurajason.moviecatalogue.data.source.remote.response

import com.bonaventurajason.moviecatalogue.data.source.model.FilmResult
import com.google.gson.annotations.SerializedName

data class FilmResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<FilmResult?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)