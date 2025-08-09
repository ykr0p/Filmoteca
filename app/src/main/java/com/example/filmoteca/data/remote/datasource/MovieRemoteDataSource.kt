// data/remote/MovieRemoteDataSource.kt
package com.example.filmoteca.data.remote

import com.example.filmoteca.data.remote.api.MovieApiService
import com.example.filmoteca.data.remote.dto.MovieResponseDto

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): MovieResponseDto
}

