package com.example.movieinfo.model.moviestarlist

import com.google.gson.annotations.SerializedName

data class MovieStarListResponseData(
    @SerializedName("peopleListResult")
    val movieStarListData: MovieStarListData?
)



