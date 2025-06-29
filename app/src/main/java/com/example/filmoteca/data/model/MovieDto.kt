package com.example.filmoteca.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MovieDto {
    РАЗОБРАТЬСЯ:
    как взаимодействуют CountryDto RetrofitInit TmdbApi CountryViewModel между собой
    LiveData
    <List<CountryDto>
    ViewModel

    в чем прикол записи:
    private val _countries = MutableLiveData<List<CountryDto>>()
    val countries: LiveData<List<CountryDto>> = _countries
}