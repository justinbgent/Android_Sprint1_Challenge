package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.movielist.MovieListAdapter
import com.example.movielist.R
import com.example.movielist.model.Data
import com.example.movielist.model.Values
import com.example.movielist.model.Values.Companion.INT_KEY
import com.example.movielist.model.Values.Companion.INT_TO_DEFAULT
import com.example.movielist.model.Values.Companion.NO_VALUES
import com.example.movielist.model.Values.Companion.STRING_KEY
import com.example.movielist.model.Values.Companion.STRING_KEY2
import com.example.movielist.model.Values.Companion.isFlagged
import com.example.movielist.model.Values.Companion.movieList
import com.example.movielist.model.Values.Companion.watched
import kotlinx.android.synthetic.main.activity_edit_movie.*

class EditMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)
        var oldMovieName: String? = intent.getStringExtra(STRING_KEY2)
        var textViewID: Int = intent.getIntExtra(INT_KEY, INT_TO_DEFAULT)

        if (oldMovieName != null) {
//Starting EditText with movie clicked
            edit_text.setText(oldMovieName, TextView.BufferType.EDITABLE)
        }

        button_save.setOnClickListener {
            if (oldMovieName != null) {
//Editing a movie
                var intent = Intent(this, MovieListActivity::class.java)
                movieList[textViewID] = Data(edit_text.text.toString())
                MovieListAdapter(movieList).notifyDataSetChanged()
                startActivity(intent)
            } else {
//Adding a movie
                var intent = Intent(this, MovieListActivity::class.java)
                Values.movieList.add(movieList.size, Data(edit_text.text.toString()))
                MovieListAdapter(movieList).notifyDataSetChanged()
                startActivity(intent)
            }
        }

        button_remove.setOnClickListener {
//Removing a movie
            Log.i("FindMe", "Found button")
            var intent = Intent(this, MovieListActivity::class.java)
            //if movieList holds no values, won't try to remove a value
            if (movieList.size != NO_VALUES) {
                Values.movieList.removeAt(textViewID)
            }
            MovieListAdapter(movieList).notifyDataSetChanged()
            startActivity(intent)
        }

        toggle_watched.setOnCheckedChangeListener { _, isChecked ->
            watched = isChecked
        }

    }
}
