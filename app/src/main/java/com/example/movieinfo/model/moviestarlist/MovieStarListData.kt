package com.example.movieinfo.model.moviestarlist

import com.google.gson.annotations.SerializedName

data class MovieStarListData(
    @SerializedName("peopleList")
    val movieStar: List<MovieStar>?
)