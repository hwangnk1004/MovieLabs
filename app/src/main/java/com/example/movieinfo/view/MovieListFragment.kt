package com.example.movieinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.adapter.MovieListRecyclerViewAdapter
import com.example.movieinfo.databinding.FragmentMovieListBinding
import com.example.movieinfo.viewmodel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val movieListViewModel: MovieListViewModel by viewModels()
    private lateinit var movieListRecyclerViewAdapter: MovieListRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        movieListViewModel.fetchMovieList()
        initRecyclerView()
        subscribeUi()
    }

    private fun initRecyclerView() {
        movieListRecyclerViewAdapter = MovieListRecyclerViewAdapter()

        binding.movieListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
            adapter = movieListRecyclerViewAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                        || newState == RecyclerView.SCROLL_STATE_DRAGGING
                    ) {
                        if (recyclerView.canScrollVertically(-1).not()) {
                            movieListViewModel.fetchInit()
                        } else if (recyclerView.canScrollVertically(1).not()) {
                            movieListViewModel.fetchMore()
                        }
                    }
                }
            })
        }
    }

    private fun initViewModel() {
        binding.lifecycleOwner = this
    }

    private fun subscribeUi() {
        movieListViewModel.movieListData.observe(viewLifecycleOwner) {
            movieListRecyclerViewAdapter.movieList = it
        }
    }


}


