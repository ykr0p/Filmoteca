// presentation/viewmodel/MovieListViewModel.kt
package com.example.filmoteca.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmoteca.domain.movie.model.Movie
import com.example.filmoteca.domain.movie.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error: SharedFlow<String> = _error.asSharedFlow()

    fun loadMovies() {
        viewModelScope.launch {
            try {
                getPopularMoviesUseCase()
                    .collect { movies ->
                        _movies.value = movies
                    }
            } catch (e: Exception) {
                _error.emit(e.message ?: "Unknown error")
            }
        }
    }
}