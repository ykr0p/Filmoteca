package com.example.filmoteca.domain.movie.model

data class Movie (
    val id: Int,
    val title: String?,
    val posterUrl: String?,
    val rating: Double
)
