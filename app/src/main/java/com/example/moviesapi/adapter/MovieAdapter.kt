package com.example.moviesapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviesapi.R
import com.example.moviesapi.databinding.MovieItemBinding
import com.example.moviesapi.model.MovieModel

class MovieAdapter(private val movieModel: List<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var onItemClick: ((MovieModel) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = MovieItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movieModel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieList = movieModel[position]
        holder.binding.apply {
            imgMoviePoster.load(movieModel[position].imageUrl)
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movieList)
        }
    }
}