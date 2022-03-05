package com.example.movieinfo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo.databinding.ItemMovieStarListBinding
import com.example.movieinfo.model.moviestarlist.MovieStarListDataUiModel

class MovieStarListRecyclerViewAdapter :
    RecyclerView.Adapter<MovieStarListRecyclerViewAdapter.MovieStarListViewHolder>() {

    var movieStarList: List<MovieStarListDataUiModel> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieStarListViewHolder {
        return MovieStarListViewHolder(
            ItemMovieStarListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieStarListViewHolder, position: Int) {
        holder.onBind(movieStarList[position], movieStarList.size, position)
    }

    override fun getItemCount(): Int {
        return movieStarList.size
    }

    class MovieStarListViewHolder(var binding: ItemMovieStarListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: MovieStarListDataUiModel, size: Int, position: Int) {
            binding.apply {
                movieStarNameInputTextView.text =
                    if (item.movieStarEnglishName?.isNotBlank() == true) {
                        item.movieStarName + "\n(${item.movieStarEnglishName})"
                    } else {
                        item.movieStarName
                    }
                movieStarListInputRole.text = item.movieStarRole
                val filmography = item.movieStarFilmography?.replace("|", ", ")
                if (filmography.isNullOrBlank()) {
                    movieStarListFilmography.visibility = View.INVISIBLE
                    movieStarListInputFilmography.visibility = View.GONE
                } else {
                    movieStarListInputFilmography.text = filmography
                }
            }
        }
    }
}