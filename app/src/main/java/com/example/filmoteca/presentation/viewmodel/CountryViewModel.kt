package com.example.filmoteca.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmoteca.data.model.CountryDto
import com.example.filmoteca.data.remote.RetrofitInit
import kotlinx.coroutines.launch

class CountryViewModel: ViewModel() {
    private val _countries = MutableLiveData<List<CountryDto>>()
    val countries: LiveData<List<CountryDto>> = _countries

    fun loadCountries() {
        viewModelScope.launch {
            try {
                val result = RetrofitInit.api.getCountries()
                _countries.value = result
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}