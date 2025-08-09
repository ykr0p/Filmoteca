package com.example.filmoteca.data.remote.dto

import com.google.gson.annotations.SerializedName

class MovieResponseDto (
    val page: Int = 0,
    val results: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int = 0,
    @SerializedName("total_results") val totalResults: Int = 0,

)