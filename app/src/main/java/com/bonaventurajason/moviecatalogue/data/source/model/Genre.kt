package com.bonaventurajason.moviecatalogue.data.source.model

import com.google.gson.annotations.SerializedName

data class Genre(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)