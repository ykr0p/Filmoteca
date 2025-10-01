package com.example.filmoteca.data.remote.api

import com.example.filmoteca.data.remote.dto.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("discover/movie")
    suspend fun getReleasedMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ): MovieResponseDto



}