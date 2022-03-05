package com.example.movieinfo.model.movielist

import com.google.gson.annotations.SerializedName

data class MovieListResponseData(
    @SerializedName("movieListResult")
    val movieListResult: MovieListData?
)

