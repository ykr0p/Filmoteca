package com.example.filmoteca.ui.movielist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmoteca.data.repository.MovieRepository
import com.example.filmoteca.domain.model.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun loadMovies() {
        viewModelScope.launch {
            try {
                Log.d("MyLog", "Loading movies...")
                val result = repository.getPopularMovies()
                Log.d("MyLog", "Movies loaded: ${result.size}")
                _movies.value = result
            } catch (e: Exception) {
                Log.d("MyLog", "Exception: ${e.message}")
            }
        }
    }
}