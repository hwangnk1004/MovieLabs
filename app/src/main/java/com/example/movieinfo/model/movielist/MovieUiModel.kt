package com.example.movieinfo.model.movielist

data class MovieUiModel(
    val movieName: String,
    val movieEnglishName: String,
    val movieProductYear: String,
    val movieType: String,
    val movieNation: String,
    val movieKind: String
) {
    companion object {
        fun newInstance(data: Movie): MovieUiModel {
            return MovieUiModel(
                movieName = data.movieName ?: "",
                movieEnglishName = data.movieEnglishName ?: "",
                movieProductYear = data.movieProductYear ?: "",
                movieType = data.movieType ?: "",
                movieNation = data.movieNation ?: "",
                movieKind = data.movieKind ?: ""
            )
        }
    }
}