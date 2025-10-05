// presentation/viewmodel/MovieListViewModelFactory.kt
package com.example.filmoteca.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmoteca.domain.movie.usecase.GetReleasedMoviesUseCase

class MovieListViewModelFactory(
    private val getPopularMoviesUseCase: GetReleasedMoviesUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            return MovieListViewModel(getPopularMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}