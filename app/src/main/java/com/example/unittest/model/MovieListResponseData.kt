package com.example.unittest.model

import com.google.gson.annotations.SerializedName

data class MovieListResponseData(
    @SerializedName("movieListResult")
    val movieListResult: MovieListData? = null
)

data class MovieListData(
    @SerializedName("movieList")
    val movieList: List<MovieList>? = null
)

data class MovieList(
    @SerializedName("movieNm")
    val movieName: String? = null,

    @SerializedName("movieNmEn")
    val movieEnglishName: String? = null,

    @SerializedName("prdtYear")
    val movieProductYear: String? = null,

    @SerializedName("typeNm")
    val movieType: String? = null,

    @SerializedName("nationAlt")
    val movieNation: String? = null,

    @SerializedName("genreAlt")
    val movieKind: String? = null,

    )