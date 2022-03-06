package com.example.movieinfo.network

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/searchMovieList.json")
    fun fetchMovieList(
        @Query("key") key: String,
        @Query("curPage") curPage: Int
    ): Call<MovieListResponseData>

    @GET("people/searchPeopleList.json")
    fun fetchMovieStarList(
        @Query("key") key: String,
        @Query("curPage") curPage: Int
    ): Call<MovieStarListResponseData>

}