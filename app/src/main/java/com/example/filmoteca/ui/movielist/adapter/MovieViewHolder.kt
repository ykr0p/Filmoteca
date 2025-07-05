package com.example.filmoteca.ui.movielist.adapter

import android.R
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmoteca.databinding.MovieItemBinding
import com.example.filmoteca.domain.model.Movie

class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(movie: Movie){
        binding.moviePoster.load(movie.posterUrl){
            crossfade(true)
            placeholder(R.drawable.ic_menu_gallery)
            error(R.drawable.ic_dialog_alert)
        }
        binding.movieRating.text = "★ ${movie.rating}"
    }
}