package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movielist.R
import com.example.movielist.model.Data
import com.example.movielist.ui.MovieListActivity.Companion.INT_KEY
import com.example.movielist.ui.MovieListActivity.Companion.STRING_KEY2
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_main.*

class EditMovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)



        button_go_back.setOnClickListener {
            var movieName = edit_text.text.toString()
            var intent = Intent(this, MovieListActivity::class.java)
//            intent.putExtra(MovieListActivity.STRING_KEY, movieName)
//            setResult(Activity.RESULT_OK, intent)

            var extras = Bundle()
            if (extras.getString(STRING_KEY2) != null) {
                var textViewID = extras.getInt(INT_KEY)
                var oldMoveName = extras.getString(STRING_KEY2)
                edit_text.hint = oldMoveName

                extras.putString(STRING_KEY2, movieName)
                extras.putInt(INT_KEY, textViewID)
                intent.putExtras(extras)
            } else {
                intent.putExtra(MovieListActivity.STRING_KEY, movieName)
                setResult(Activity.RESULT_OK, intent)
            }


            finish()
        }
    }
}

//var extras = Bundle()
//extras.putString(STRING_KEY, movie.id)
//extras.putInt(INT_KEY, movie.id)
//intent.putExtras(extras)
