package com.example.filmoteca.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoteca.R
import com.example.filmoteca.data.datasources.remote.movie.MovieRemoteDataSourceImpl
import com.example.filmoteca.data.remote.network.RetrofitInit
import com.example.filmoteca.data.repositoryimpl.MovieRepositoryImpl
import com.example.filmoteca.databinding.ActivityMainBinding
import com.example.filmoteca.domain.movie.model.Movie
import com.example.filmoteca.domain.movie.usecase.GetReleasedMoviesUseCase
import com.example.filmoteca.presentation.viewmodel.MovieListViewModel
import com.example.filmoteca.presentation.viewmodel.MovieListViewModelFactory
import com.example.filmoteca.ui.movie.adapter.MovieAdapter
import kotlinx.coroutines.launch
import nl.joery.animatedbottombar.AnimatedBottomBar



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav(binding.mainActBottomNav, this)










        // Инициализация зависимостей
        val api = RetrofitInit.api
        val remoteDataSource = MovieRemoteDataSourceImpl(api)
        val repository = MovieRepositoryImpl(remoteDataSource)
        val useCase = GetReleasedMoviesUseCase(repository)
        val factory = MovieListViewModelFactory(useCase)

        // Создание ViewModel
        viewModel = ViewModelProvider(this, factory)[MovieListViewModel::class.java]

        // Настройка RecyclerView
        adapter = MovieAdapter()
        binding.moviesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.moviesRecyclerView.adapter = adapter

        // Подписка на данные
        lifecycleScope.launch {
            viewModel.movies.collect { movies ->
                adapter.setItems(movies)
            }
        }

        // Подписка на ошибки
        lifecycleScope.launch {
            viewModel.error.collect { error ->
                Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
            }
        }

        // Загрузка данных
        viewModel.loadMovies()

    }






}
