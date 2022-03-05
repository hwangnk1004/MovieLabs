package com.example.movieinfo.repository

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import com.example.movieinfo.source.MovieDataSource

class MovieRepository(private val source: MovieDataSource) {

    private var movieListNextPage = 1
    private var movieStarListNextPage = 1

    suspend fun fetchMovieList(top:Boolean): MovieListResponseData? {
        if (top) movieListNextPage = 1
        return source.fetchMovieList(10 * movieListNextPage++)
    }

    suspend fun fetchMovieStarList(top:Boolean): MovieStarListResponseData? {
        if (top) movieStarListNextPage = 1
        return source.fetchMovieStarList(10 * movieStarListNextPage++)
    }
}
