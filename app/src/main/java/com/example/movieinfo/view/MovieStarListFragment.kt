package com.example.movieinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieinfo.databinding.FragmentMovieStarListBinding
import com.example.movieinfo.viewmodel.MovieStarListViewModel

class MovieStarListFragment : Fragment() {

    private lateinit var binding: FragmentMovieStarListBinding
    private lateinit var movieStarListViewModel: MovieStarListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initViewModel()
        subscribeUi()
        movieStarListViewModel.fetchMovieStarList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieStarListBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initRecyclerView() {

    }

    private fun initViewModel() {
        movieStarListViewModel = ViewModelProvider(this)[MovieStarListViewModel::class.java]
        binding.lifecycleOwner = this
    }

    private fun subscribeUi() {
        movieStarListViewModel.movieStarListData.observe(viewLifecycleOwner) {
        }
    }
}