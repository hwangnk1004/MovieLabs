package com.example.unittest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unittest.model.MovieStarListData
import com.example.unittest.model.MovieStarListResponseData
import com.example.unittest.repository.MovieRepository
import com.example.unittest.repository.RemoteMovieDataSource
import kotlinx.coroutines.launch

class MovieStarListViewModel : ViewModel() {

    private val repo = MovieRepository(RemoteMovieDataSource())

    private val _movieStarListData = MutableLiveData<MovieStarListData>()
    val movieStarListData: LiveData<MovieStarListData> = _movieStarListData

    fun fetchMovieStarList() {
        viewModelScope.launch {
            val result: MovieStarListResponseData? = repo.fetchMovieStarList()
            result?.movieStarListData?.let {
                _movieStarListData.value = it
            }
        }
    }

}