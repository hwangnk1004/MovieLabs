package com.example.unittest.repository

import com.example.unittest.model.MovieListResponseData
import com.example.unittest.model.MovieStarListResponseData
import com.example.unittest.source.MovieDataSource

class MovieRepository(private val source: MovieDataSource) {

    suspend fun fetchMovieList(): MovieListResponseData? {
        return source.fetchMovieList()
    }

    suspend fun fetchMovieStarList(): MovieStarListResponseData? {
        return source.fetchMovieStarList()
    }
}