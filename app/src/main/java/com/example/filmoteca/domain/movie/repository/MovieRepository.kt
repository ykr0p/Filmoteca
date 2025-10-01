// domain/movie/repository/MovieRepository.kt
package com.example.filmoteca.domain.movie.repository

import com.example.filmoteca.domain.movie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getReleasedMovies(): Flow<List<Movie>>
}