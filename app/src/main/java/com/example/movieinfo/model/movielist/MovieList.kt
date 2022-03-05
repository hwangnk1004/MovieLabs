package com.example.movieinfo.model.movielist

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("movieNm")
    val movieName: String = "",

    @SerializedName("movieNmEn")
    val movieEnglishName: String = "",

    @SerializedName("prdtYear")
    val movieProductYear: String = "",

    @SerializedName("typeNm")
    val movieType: String = "",

    @SerializedName("nationAlt")
    val movieNation: String = "",

    @SerializedName("genreAlt")
    val movieKind: String = "",

    )