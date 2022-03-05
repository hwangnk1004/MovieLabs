package com.example.movieinfo.source

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData

interface MovieDataSource {
    suspend fun fetchMovieList(): MovieListResponseData?

    suspend fun fetchMovieStarList(): MovieStarListResponseData?
}