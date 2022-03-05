package com.example.movieinfo.source

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData

interface MovieDataSource {
    suspend fun fetchMovieList(index:Int): MovieListResponseData?

    suspend fun fetchMovieStarList(index:Int): MovieStarListResponseData?
}