package com.example.movieinfo.model.moviestarlist

import com.google.gson.annotations.SerializedName

data class MovieStar(
    @SerializedName("peopleNm")
    val movieStarName: String?,

    @SerializedName("peopleNmEn")
    val movieStarEnglishName: String?,

    @SerializedName("repRoleNm")
    val movieStarRole: String?,

    @SerializedName("filmoNames")
    val movieStarFilmography: String?


)