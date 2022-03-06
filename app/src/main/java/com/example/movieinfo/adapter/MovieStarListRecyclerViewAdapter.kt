package com.example.movieinfo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.databinding.ItemMovieStarListBinding
import com.example.movieinfo.model.moviestarlist.MovieStarUiModel

class MovieStarListRecyclerViewAdapter :
    ListAdapter<MovieStarUiModel, MovieStarListRecyclerViewAdapter.MovieStarViewHolder>(
        diffUtil
    ) {

    init {
        setHasStableIds(true)
    }

    override fun getItem(position: Int): MovieStarUiModel {
        return currentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class MovieStarViewHolder(var binding: ItemMovieStarListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: MovieStarUiModel) {
            binding.apply {
                movieStarNameInputTextView.text =
                    if (item.movieStarEnglishName.isNotBlank()) {
                        item.movieStarName + "\n(${item.movieStarEnglishName})"
                    } else {
                        item.movieStarName
                    }
                movieStarListInputRole.text = item.movieStarRole
                val filmography = item.movieStarFilmography.replace("|", ", ")
                if (filmography.isBlank()) {
                    movieStarListFilmography.visibility = View.INVISIBLE
                    movieStarListInputFilmography.visibility = View.GONE
                } else {
                    movieStarListInputFilmography.text = filmography
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieStarViewHolder {
        return MovieStarViewHolder(
            ItemMovieStarListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieStarViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MovieStarUiModel>() {
            override fun areItemsTheSame(
                oldItem: MovieStarUiModel,
                newItem: MovieStarUiModel
            ): Boolean {
                return newItem.movieStarEnglishName == oldItem.movieStarEnglishName
            }

            override fun areContentsTheSame(
                oldItem: MovieStarUiModel,
                newItem: MovieStarUiModel
            ): Boolean {

                return newItem == oldItem
            }

        }
    }
}