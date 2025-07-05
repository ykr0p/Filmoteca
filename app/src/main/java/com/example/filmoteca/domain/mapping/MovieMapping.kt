package com.example.filmoteca.domain.mapping

import com.example.filmoteca.data.remote.dto.MovieDto
import com.example.filmoteca.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = this.id,
        title = "Фильм #${this.id}", // или добавь title в MovieDto, если появится
        posterUrl = "https://image.tmdb.org/t/p/w500${this.posterPath ?: ""}",
        rating = this.rate
    )
}

