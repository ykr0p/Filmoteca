package com.example.filmoteca.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInit {

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(
                    "Authorization",
                    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NmExODBhMDJiZGJjZTVhODg4YTAwYmU5NDM1ZjY4ZSIsIm5iZiI6MTc1MDYxMTUxOC40MzYsInN1YiI6IjY4NTgzNjNlYjllM2MzMjkxZWE3OTZlMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nYdbPsL2zDZ_43ux73lDZA_UaDq8XcpoE1uFm6OpkUY"
                )
                .addHeader("accept", "application/json")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val api: TmdbApi = retrofit.create(TmdbApi::class.java)

}