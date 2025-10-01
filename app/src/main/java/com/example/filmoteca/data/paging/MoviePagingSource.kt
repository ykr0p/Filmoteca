package com.example.filmoteca.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmoteca.data.datasources.remote.movie.MovieRemoteDataSource
import com.example.filmoteca.domain.movie.model.Movie

//class MoviePagingSource (
//    private val remoteDataSource: MovieRemoteDataSource
//) : PagingSource<Int, Movie>() {
//
//
//
//
//    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
//        // Находим позицию, к которой пользователь прокрутил
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
//        return try {
//            val page = params.key ?: 1
//            val response = MovieRemoteDataSource.getPopularMovies()
//
//            LoadResult.Page(
//                data = response.movies,
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (response.movies.isEmpty()) null else page + 1
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}