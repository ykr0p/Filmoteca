package com.example.filmoteca.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoteca.R
import com.example.filmoteca.data.datasources.remote.movie.MovieRemoteDataSourceImpl
import com.example.filmoteca.data.remote.network.RetrofitInit
import com.example.filmoteca.data.repositoryimpl.MovieRepositoryImpl
import com.example.filmoteca.databinding.ActivityMainBinding
import com.example.filmoteca.databinding.FragmentExploreBinding
import com.example.filmoteca.domain.movie.usecase.GetReleasedMoviesUseCase
import com.example.filmoteca.presentation.viewmodel.MovieListViewModel
import com.example.filmoteca.presentation.viewmodel.MovieListViewModelFactory
import com.example.filmoteca.ui.movie.adapter.MovieAdapter
import kotlinx.coroutines.launch

class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MovieListViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
        binding.exploreRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.exploreRecyclerView.adapter = adapter

        // Подписка на данные
        lifecycleScope.launch {
            viewModel.movies.collect { movies ->
                adapter.setItems(movies)
            }
        }

        // Подписка на ошибки
        lifecycleScope.launch {
            viewModel.error.collect { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            }
        }

        // Загрузка данных
        viewModel.loadMovies()

    }
}