package com.example.filmoteca.domain.movie.usecase

import com.example.filmoteca.domain.movie.model.Movie
import com.example.filmoteca.domain.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> = repository.getPopularMovies()
}

