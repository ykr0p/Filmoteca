package com.example.filmoteca.data.datasources.remote.movie

import com.example.filmoteca.data.remote.dto.MovieResponseDto

interface MovieRemoteDataSource {
   fun getReleasedMovies(): MovieResponseDto
}