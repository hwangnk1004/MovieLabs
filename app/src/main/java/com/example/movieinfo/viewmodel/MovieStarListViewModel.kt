package com.example.movieinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.model.moviestarlist.MovieStarListData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import com.example.movieinfo.repository.MovieRepository
import com.example.movieinfo.repository.RemoteMovieDataSource
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