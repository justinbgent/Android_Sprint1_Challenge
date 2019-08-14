package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import com.example.movielist.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Paint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.MovieListAdapter
import com.example.movielist.model.Values.Companion.EDIT_TEXT_KEY
import com.example.movielist.model.Values.Companion.INT_KEY
import com.example.movielist.model.Values.Companion.INT_TO_DEFAULT
import com.example.movielist.model.Values.Companion.STRING_KEY
import com.example.movielist.model.Values.Companion.STRING_KEY2
import com.example.movielist.model.Values.Companion.TITLE_REQUEST_KEY
import com.example.movielist.model.Values.Companion.movieList
import com.example.movielist.model.Values.Companion.onlyOnce
import com.example.movielist.model.Values.Companion.watched


class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.movielist.R.layout.activity_main)

        if (onlyOnce) {
            movieList.add(Data("Tarzan1"))
            movieList.add(Data("Tarzan2"))
            movieList.add(Data("Tarzan3"))
            movieList.add(Data("Tarzan4"))
            movieList.add(Data("Tarzan5"))
            movieList.add(Data("Tarzan6"))
            movieList.add(Data("Tarzan7"))
            movieList.add(Data("Tarzan8"))
            movieList.add(Data("Tarzan9"))
            movieList.add(Data("Tarzan10"))
            movieList.add(Data("Tarzan11"))
            movieList.add(Data("Tarzan12"))
            onlyOnce = false
        }

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MovieListAdapter(movieList)
        list_view.layoutManager = manager
        list_view.adapter = adapter

        button_add_movie.setOnClickListener {
            var intent = Intent(this, EditMovieActivity::class.java)
            startActivity(intent)
        }
    }
}