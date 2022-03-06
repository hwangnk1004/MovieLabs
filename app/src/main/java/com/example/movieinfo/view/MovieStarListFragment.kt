package com.example.movieinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.adapter.MovieStarListRecyclerViewAdapter
import com.example.movieinfo.databinding.FragmentMovieStarListBinding
import com.example.movieinfo.viewmodel.MovieStarListViewModel

class MovieStarListFragment : Fragment() {

    private lateinit var binding: FragmentMovieStarListBinding
    private val movieStarListViewModel: MovieStarListViewModel by viewModels()
    private val movieStarListRecyclerViewAdapter by lazy { MovieStarListRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieStarListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        movieStarListViewModel.fetchMovieStarList()
        initRecyclerView()
        subscribeUi()

    }

    private fun initRecyclerView() {
        binding.movieStarListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
            adapter = movieStarListRecyclerViewAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                        || newState == RecyclerView.SCROLL_STATE_DRAGGING
                    ) {
                        if (recyclerView.canScrollVertically(-1).not()) {
                            movieStarListViewModel.fetchInit()
                        } else if (recyclerView.canScrollVertically(1).not()) {
                            movieStarListViewModel.fetchMore()
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
        movieStarListViewModel.mMovieStar.observe(viewLifecycleOwner) {
            it.let {
                movieStarListRecyclerViewAdapter.submitList(it)
            }
        }
    }
}