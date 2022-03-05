package com.example.movieinfo.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.databinding.ItemMovieListBinding
import com.example.movieinfo.model.movielist.MovieListDataUiModel

class MovieListRecyclerViewAdapter :
    RecyclerView.Adapter<MovieListRecyclerViewAdapter.MovieListViewHolder>() {

    var movieList: List<MovieListDataUiModel> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            ItemMovieListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(movieList[position], movieList.size, position)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieListViewHolder(var binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: MovieListDataUiModel, size: Int, position: Int) {
            binding.apply {
                movieNameInputTextView.text = if (item.movieEnglishName?.isNotBlank() == true) {
                    item.movieName + "\n(${item.movieEnglishName})"
                } else {
                    item.movieName
                }
                movieListInputYear.text = item.movieProductYear
                movieListInputType.text = item.movieType
                movieListInputNation.text = item.movieNation
                movieListInputAlt.text = item.movieKind
            }
        }
    }
}