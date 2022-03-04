package com.example.unittest.model

import com.google.gson.annotations.SerializedName

data class MovieStarListResponseData(
    @SerializedName("peopleListResult")
    val movieStarListData: MovieStarListData? = null
)

data class MovieStarListData(
    @SerializedName("peopleList")
    val movieStar: List<MovieStarList>? = null
)

data class MovieStarList(
    @SerializedName("peopleNm")
    val movieStarName: String? = null,

    @SerializedName("peopleNmEn")
    val movieStarEnglishName: String? = null,

    @SerializedName("repRoleNm")
    val movieStarRole: String? = null,

    @SerializedName("filmoNames")
    val movieStarFilmography: String? = null


)