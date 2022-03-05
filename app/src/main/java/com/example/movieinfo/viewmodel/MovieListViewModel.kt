package com.example.movieinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.model.movielist.MovieListData
import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.repository.RemoteMovieDataSource
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val repo = MovieRepository(RemoteMovieDataSource())

    private val _movieListData = MutableLiveData<MovieListData>()
    val movieListData: LiveData<MovieListData> = _movieListData

    fun fetchMovieList() {
        viewModelScope.launch {
            val result: MovieListResponseData? = repo.fetchMovieList()
            result?.movieListResult?.let {
                _movieListData.value = it
            }
        }
    }
}