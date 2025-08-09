package com.example.filmoteca.data.remote.datasourceimpl
import com.example.filmoteca.data.remote.MovieRemoteDataSource
import com.example.filmoteca.data.remote.api.MovieApiService
import com.example.filmoteca.data.remote.dto.MovieResponseDto

class MovieRemoteDataSourceImpl(
    private val api: MovieApiService
) : MovieRemoteDataSource {
    override suspend fun getPopularMovies(): MovieResponseDto {
        return api.getPopularMovies()
    }
}