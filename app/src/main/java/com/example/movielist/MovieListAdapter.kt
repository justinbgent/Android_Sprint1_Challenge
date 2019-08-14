package com.example.movielist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.model.Data
import com.example.movielist.model.Values
import com.example.movielist.ui.EditMovieActivity
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieListAdapter(private val data: MutableList<Data>): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return ViewHolder(viewGroup)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movie.text = data[position].movieTitle
        holder.movie.id = position
        holder.movie.setOnClickListener{
            var intent = Intent(holder.movie.context, EditMovieActivity::class.java)
            intent.putExtra(Values.INT_KEY, holder.movie.id)
            intent.putExtra(Values.STRING_KEY2, holder.movie.text.toString())
            holder.movie.context.startActivity(intent)

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val movie: TextView = view.movie_name
    }

}