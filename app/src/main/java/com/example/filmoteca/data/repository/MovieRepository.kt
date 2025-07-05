package com.example.filmoteca.data.repository

import com.example.filmoteca.data.remote.api.MovieApi
import com.example.filmoteca.domain.mapping.toDomain
import com.example.filmoteca.domain.model.Movie


class MovieRepository(private val api: MovieApi) {

    suspend fun getPopularMovies(): List<Movie> {
        val response = api.getPopularMovies()
        return response.results.map { it.toDomain() }
    }
}