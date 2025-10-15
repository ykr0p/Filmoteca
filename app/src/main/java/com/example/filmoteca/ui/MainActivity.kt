package com.example.filmoteca.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoteca.data.datasources.remote.movie.MovieRemoteDataSourceImpl
import com.example.filmoteca.data.remote.network.RetrofitInit
import com.example.filmoteca.data.repositoryimpl.MovieRepositoryImpl
import com.example.filmoteca.databinding.ActivityMainBinding
import com.example.filmoteca.domain.movie.usecase.GetReleasedMoviesUseCase
import com.example.filmoteca.presentation.viewmodel.MovieListViewModel
import com.example.filmoteca.presentation.viewmodel.MovieListViewModelFactory
import com.example.filmoteca.ui.movie.adapter.MovieAdapter
import kotlinx.coroutines.launch

import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        hideSystemUI()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // bottom nav
        setupBottomNav(binding.mainActBottomNav, this)

    }


    // hide native android bottom navigation
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let { controller ->
                controller.hide(android.view.WindowInsets.Type.navigationBars() or android.view.WindowInsets.Type.statusBars())
                controller.systemBarsBehavior =
                    android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }


}
