package com.example.movieinfo.repository

import android.util.Log
import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import com.example.movieinfo.source.MovieDataSource

class MovieRepository(private val source: MovieDataSource) {

    private var movieListNextPage = 0
    private var movieStarListNextPage = 0

    suspend fun fetchMovieList(top: Boolean): MovieListResponseData? {
        return when {
            top -> {
                movieListNextPage--
                source.fetchMovieList(if (movieListNextPage < 1) 1 else movieListNextPage)
            }
            else -> {
                source.fetchMovieList(++movieListNextPage)
            }
        }
    }

    suspend fun fetchMovieStarList(top: Boolean): MovieStarListResponseData? {
        return when {
            top -> {
                movieStarListNextPage--
                source.fetchMovieStarList(if (movieStarListNextPage < 1) 1 else movieStarListNextPage)
            }
            else -> source.fetchMovieStarList(++movieStarListNextPage)
        }
    }
}
