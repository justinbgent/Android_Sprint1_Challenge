package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movielist.R
import com.example.movielist.model.Data
import com.example.movielist.ui.MovieListActivity.Companion.INT_KEY
import com.example.movielist.ui.MovieListActivity.Companion.STRING_KEY
import com.example.movielist.ui.MovieListActivity.Companion.STRING_KEY2
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_main.*

class EditMovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)



        button_go_back.setOnClickListener {
//            intent.putExtra(MovieListActivity.STRING_KEY, movieName)
//            setResult(Activity.RESULT_OK, intent)


            if (intent.getStringExtra(STRING_KEY2) != null) {
                var textViewID: Int = intent.getIntExtra(STRING_KEY, 11)
                var oldMoveName: String = intent.getStringExtra(STRING_KEY2) ?: "NoData"
                edit_text.hint = oldMoveName
                var intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra(STRING_KEY, textViewID)
                intent.putExtra(STRING_KEY2, oldMoveName)
                setResult(Activity.RESULT_OK, intent)

                Log.i("FindMe", "Found 1")
            } else {
                var movieName = edit_text.text.toString()
                var intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra(STRING_KEY, movieName)
                setResult(Activity.RESULT_OK, intent)
                Log.i("FindMe", "Found 2")
            }
            finish()
        }
    }
}
