package com.example.filmoteca

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoteca.data.remote.network.RetrofitInit
import com.example.filmoteca.data.repository.MovieRepository
import com.example.filmoteca.databinding.ActivityMainBinding
import com.example.filmoteca.ui.movielist.adapter.MovieAdapter
import com.example.filmoteca.ui.movielist.viewmodel.MovieListViewModel
import com.example.filmoteca.ui.movielist.viewmodel.MovieListViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "onCreate called")
        val api = RetrofitInit.api
        val repository = MovieRepository(api)
        val factory = MovieListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MovieListViewModel::class.java]


        binding.moviesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = MovieAdapter(emptyList())
        binding.moviesRecyclerView.adapter = adapter

        viewModel.movies.observe(this) { movies ->
            Log.d("MyLog", "Movies received: ${movies.size}")
            adapter.setItems(movies)
        }

        viewModel.loadMovies()
    }
}
