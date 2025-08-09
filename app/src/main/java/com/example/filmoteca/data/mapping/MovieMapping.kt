package com.example.filmoteca.data.mapping

import com.example.filmoteca.data.remote.dto.MovieDto
import com.example.filmoteca.domain.movie.model.Movie

fun MovieDto.toDomain(): Movie = Movie(
    id = id,
    title = title,
    posterUrl = posterPath?.let { if (it.isNotBlank()) "https://image.tmdb.org/t/p/w500$it" else null },
    rating = voteAverage.coerceIn(0.0..10.0),


)