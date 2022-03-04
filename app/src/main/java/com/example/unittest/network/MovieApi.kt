package com.example.unittest.network

import com.example.unittest.model.MovieListResponseData
import com.example.unittest.model.MovieStarListResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/searchMovieList.json")
    fun fetchMovieList(@Query("key") key: String?): Call<MovieListResponseData>

    @GET("people/searchPeopleList.json")
    fun fetchMovieStarList(@Query("key") key: String?): Call<MovieStarListResponseData>
}