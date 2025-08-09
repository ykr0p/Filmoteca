package com.example.filmoteca.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmoteca.databinding.MovieItemBinding
import com.example.filmoteca.domain.movie.model.Movie

class MovieAdapter(
    private var movies: List<Movie> = emptyList()
) : RecyclerView.Adapter<MovieViewHolder>() {

    fun setItems(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged() // Простое обновление всего списка
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}