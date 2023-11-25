package com.example.filmlist.screens.startscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlist.IMAGE_BASE_URL
import com.example.filmlist.MAINACT
import com.example.filmlist.R
import com.example.filmlist.models.startmodel.MovieItemModel

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var moviesList = emptyList<MovieItemModel>()
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val item_title_text: TextView = view.findViewById(R.id.item_title_text)
        val rv_item_image: ImageView = view.findViewById(R.id.rv_item_image)
        val item_release_text: TextView = view.findViewById(R.id.item_release_text)
        val item_vote_text: TextView = view.findViewById(R.id.item_vote_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_film_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item_title_text.text = moviesList[position].title
        holder.item_release_text.text = moviesList[position].release_date
        holder.item_vote_text.text = "${moviesList[position].vote_average}"
        Glide.with(MAINACT).load(IMAGE_BASE_URL + moviesList[position].poster_path)
            .centerCrop().placeholder(R.drawable.baseline_downloading_24).into(holder.rv_item_image)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setMovieList(list: List<MovieItemModel>){
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickMovie(moviesList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}