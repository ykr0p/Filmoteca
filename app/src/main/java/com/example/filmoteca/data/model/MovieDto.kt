package com.example.filmoteca.data.model

import com.google.gson.annotations.SerializedName

data class MovieDto (
        val id: Int,
        @SerializedName("poster_path") val posterPath: String?,
        @SerializedName("vote_average") val rate: Double,

)