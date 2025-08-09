package com.example.filmoteca.data.remote.api

import com.example.filmoteca.data.remote.dto.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("language") language: String = "ru-RU",
        @Query("sort_by") sortBy: String = "primary_release_date.desc",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("page") page: Int = 1

    ): MovieResponseDto


}