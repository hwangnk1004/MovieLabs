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
                movieListNextPage = 1
                source.fetchMovieList(movieListNextPage)
            }
            else -> {
                source.fetchMovieList(++movieListNextPage)
            }
        }
    }

    suspend fun fetchMovieStarList(top: Boolean): MovieStarListResponseData? {
        return when {
            top -> {
                movieStarListNextPage = 1
                source.fetchMovieStarList(movieStarListNextPage)
            }
            else -> source.fetchMovieStarList(++movieStarListNextPage)
        }
    }
}
