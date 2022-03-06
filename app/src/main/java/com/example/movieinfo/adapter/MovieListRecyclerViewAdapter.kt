package com.example.movieinfo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.databinding.ItemMovieListBinding
import com.example.movieinfo.model.movielist.MovieUiModel

class MovieListRecyclerViewAdapter :
    ListAdapter<MovieUiModel, MovieListRecyclerViewAdapter.MovieViewHolder>(diffUtil) {

    init {
        setHasStableIds(true)
    }

    override fun getItem(position: Int): MovieUiModel {
        return currentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class MovieViewHolder(var binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: MovieUiModel) {
            binding.apply {
                movieNameInputTextView.text = if (item.movieEnglishName.isNotBlank()) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MovieUiModel>() {
            override fun areItemsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean {
                return newItem.movieKind == oldItem.movieKind
            }

            override fun areContentsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean {
                return newItem == oldItem
            }
        }
    }
}