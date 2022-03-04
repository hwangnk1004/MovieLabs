package com.example.unittest.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.unittest.databinding.FragmentMovieListBinding
import com.example.unittest.viewmodel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("nkh","onViewCreated")
        initRecyclerView()
        initViewModel()
        subscribeUi()
        movieListViewModel.fetchMovieList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initRecyclerView() {

    }

    private fun initViewModel() {
        movieListViewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        binding.lifecycleOwner = this
        binding.movieListViewModel = movieListViewModel
    }

    private fun subscribeUi() {
        movieListViewModel.movieListData.observe(viewLifecycleOwner) {
            Log.d("nkh", "test!! ${it.movieList?.get(0)?.movieName}")
        }
    }


}