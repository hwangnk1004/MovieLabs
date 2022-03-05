package com.example.movieinfo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieinfo.databinding.FragmentMovieListBinding
import com.example.movieinfo.viewmodel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val movieListViewModel: MovieListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.lifecycleOwner = this
    }

    private fun subscribeUi() {
        movieListViewModel.movieListData.observe(viewLifecycleOwner) {

        }
    }


}


