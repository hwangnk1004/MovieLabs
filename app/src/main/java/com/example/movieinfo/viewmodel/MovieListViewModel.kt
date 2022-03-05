package com.example.movieinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.model.movielist.MovieListData
import com.example.movieinfo.model.movielist.MovieListDataUiModel
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.repository.RemoteMovieDataSource
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val repo = MovieRepository(RemoteMovieDataSource())

    private val _movieListData = MutableLiveData<List<MovieListDataUiModel>>()
    val movieListData: LiveData<List<MovieListDataUiModel>> = _movieListData

    fun fetchMovieList() {
        viewModelScope.launch {
            val result: MovieListData? = repo.fetchMovieList(false)?.movieListResult
            val movieUiModelList = result?.movie?.map { data ->
                MovieListDataUiModel.newInstance(data)
            }.orEmpty()
            _movieListData.value = movieUiModelList

        }
    }

    fun fetchMore() {
        viewModelScope.launch {
            val result: MovieListData = repo.fetchMovieList(false)?.movieListResult ?: return@launch
            val movieUiModelList = result.movie?.map { data ->
                MovieListDataUiModel.newInstance(data)
            }.orEmpty()

            _movieListData.value = movieUiModelList
        }
    }

    fun fetchInit() {
        viewModelScope.launch {
            val result: MovieListData = repo.fetchMovieList(true)?.movieListResult ?: return@launch
            val movieUiModelList = result.movie?.map { data ->
                MovieListDataUiModel.newInstance(data)
            }.orEmpty()

            _movieListData.value = movieUiModelList
        }
    }
}