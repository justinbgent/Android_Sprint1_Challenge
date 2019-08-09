package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movielist.R
import com.example.movielist.model.Data
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_main.*

class EditMovieActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)


        button_go_back.setOnClickListener {
            var movieName = edit_text.text.toString()
            var intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(MovieListActivity.STRING_KEY, movieName)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
