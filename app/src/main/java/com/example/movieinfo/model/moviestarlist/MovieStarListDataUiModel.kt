package com.example.movieinfo.model.moviestarlist

data class MovieStarListDataUiModel(
    val movieStarName: String?,
    val movieStarEnglishName: String?,
    val movieStarRole: String?,
    val movieStarFilmography: String?
) {
    companion object {
        fun newInstance(data: MovieStar): MovieStarListDataUiModel {
            return MovieStarListDataUiModel(
                movieStarName = data.movieStarName,
                movieStarEnglishName = data.movieStarEnglishName,
                movieStarRole = data.movieStarRole,
                movieStarFilmography = data.movieStarFilmography
            )
        }
    }
}