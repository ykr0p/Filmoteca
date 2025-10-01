package com.example.filmoteca.data.remote.dto

import com.google.gson.annotations.SerializedName

class MovieResponseDto (
    val page: Int,
    val results: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,

)