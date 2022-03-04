package com.example.unittest.source

import com.example.unittest.model.MovieListResponseData
import com.example.unittest.model.MovieStarListResponseData

interface MovieDataSource {
    suspend fun fetchMovieList(): MovieListResponseData?

    suspend fun fetchMovieStarList(): MovieStarListResponseData?
}