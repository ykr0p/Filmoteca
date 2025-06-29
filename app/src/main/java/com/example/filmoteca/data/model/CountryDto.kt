package com.example.filmoteca.data.model

import com.google.gson.annotations.SerializedName

data class CountryDto (
        @SerializedName("iso_3166_1") val code: String,
        @SerializedName("english_name") val englishName: String,
        @SerializedName("native_name") val nativeName: String
)