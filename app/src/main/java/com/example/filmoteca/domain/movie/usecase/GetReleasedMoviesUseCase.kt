package com.example.filmoteca.domain.movie.usecase

import com.example.filmoteca.domain.movie.model.Movie
import com.example.filmoteca.domain.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetReleasedMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> = repository.getReleasedMovies()
}

