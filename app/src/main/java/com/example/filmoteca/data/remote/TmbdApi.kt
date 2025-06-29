package com.example.filmoteca.data.remote

import com.example.filmoteca.data.model.CountryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("configuration/countries")
    suspend fun getCountries(
        @Query("language") language: String = "en-US"
    ): List<CountryDto>
}