package com.example.movieinfo.model.movielist

import com.google.gson.annotations.SerializedName

data class MovieListData(
    @SerializedName("movieList")
    val movie: List<Movie>?
)