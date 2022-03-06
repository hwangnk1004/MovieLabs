package com.example.movieinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.model.moviestarlist.MovieStarListData
import com.example.movieinfo.model.moviestarlist.MovieStarUiModel
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.repository.RemoteMovieDataSource
import kotlinx.coroutines.launch

class MovieStarListViewModel : ViewModel() {

    private val repo = MovieRepository(RemoteMovieDataSource())

    private val _movieStarListData = MutableLiveData<List<MovieStarUiModel>>()
    val movieStartListData: LiveData<List<MovieStarUiModel>> = _movieStarListData

    fun fetchMovieStarList() {
        viewModelScope.launch {
            val result: MovieStarListData? = repo.fetchMovieStarList(false)?.movieStarListData
            val movieStarUiModelList = result?.movieStar?.map { data ->
                MovieStarUiModel.newInstance(data)
            }.orEmpty()

            _movieStarListData.value = movieStarUiModelList
        }
    }

    fun fetchMore() {
        viewModelScope.launch {
            val result: MovieStarListData =
                repo.fetchMovieStarList(false)?.movieStarListData ?: return@launch

            val movieStarUiModelList = result.movieStar?.map { data ->
                MovieStarUiModel.newInstance(data)
            }.orEmpty()

            _movieStarListData.value = movieStarUiModelList
        }
    }

    fun fetchInit() {
        viewModelScope.launch {
            val result: MovieStarListData =
                repo.fetchMovieStarList(true)?.movieStarListData ?: return@launch

            val movieStarUiModelList = result.movieStar?.map { data ->
                MovieStarUiModel.newInstance(data)
            }.orEmpty()

            _movieStarListData.value = movieStarUiModelList
        }
    }

}