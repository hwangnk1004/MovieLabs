package com.example.unittest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unittest.model.MovieListData
import com.example.unittest.model.MovieListResponseData
import com.example.unittest.repository.MovieRepository
import com.example.unittest.repository.RemoteMovieDataSource
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