package com.example.filmoteca.ui.movie.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmoteca.databinding.MovieItemBinding
import com.example.filmoteca.domain.movie.model.Movie

class MovieViewHolder(
    private val binding: MovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            // Простая загрузка изображения
            moviePoster.load(movie.posterUrl)

            // Отображение рейтинга
            movieRating.text = "★ ${"%.1f".format(movie.rating)}"
        }
    }
}