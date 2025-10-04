package com.example.filmoteca.data.repositoryimpl

import com.example.filmoteca.data.remote.api.MovieApiService
import com.example.filmoteca.data.mapping.toDomain
import com.example.filmoteca.data.datasources.remote.movie.MovieRemoteDataSource
import com.example.filmoteca.domain.movie.model.Movie
import com.example.filmoteca.domain.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MovieRepositoryImpl( private val remoteDataSource: MovieRemoteDataSource): MovieRepository {

    override fun getReleasedMovies(): Flow<List<Movie>> = flow {
        try {
            val response = remoteDataSource.getReleasedMovies()
            emit(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            throw e
        }
    }



}