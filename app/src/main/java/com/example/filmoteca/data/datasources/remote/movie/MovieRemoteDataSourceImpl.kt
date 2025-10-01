package com.example.filmoteca.data.datasources.remote.movie

import com.example.filmoteca.data.remote.api.MovieApiService
import com.example.filmoteca.data.remote.dto.MovieResponseDto

class MovieRemoteDataSourceImpl( private val api: MovieApiService): MovieRemoteDataSource {

    override suspend fun getReleasedMovies(): MovieResponseDto {
        return api.getReleasedMovies()
    }

}