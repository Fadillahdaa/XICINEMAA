package com.kelmobile.projekakhir2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMovie: ImageView = view.findViewById(R.id.imgMovie)
        val tvMovieTitle: TextView = view.findViewById(R.id.tvMovieTitle)
        val tvMovieGenre: TextView = view.findViewById(R.id.tvMovieGenre)
        val tvMovieRating: TextView = view.findViewById(R.id.tvMovieRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.tvMovieTitle.text = movie.title
        holder.tvMovieGenre.text = movie.genre
        holder.tvMovieRating.text = movie.rating
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.imgMovie)
    }

    override fun getItemCount(): Int = movies.size
}
