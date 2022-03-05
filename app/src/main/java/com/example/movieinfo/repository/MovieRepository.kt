package com.example.movieinfo.repository

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import com.example.movieinfo.source.MovieDataSource

class MovieRepository(private val source: MovieDataSource) {

    suspend fun fetchMovieList(): MovieListResponseData? {
        return source.fetchMovieList()
    }

    suspend fun fetchMovieStarList(): MovieStarListResponseData? {
        return source.fetchMovieStarList()
    }
}