package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.movielist.R
import com.example.movielist.model.Values.Companion.INT_KEY
import com.example.movielist.model.Values.Companion.INT_TO_DEFAULT
import com.example.movielist.model.Values.Companion.STRING_KEY
import com.example.movielist.model.Values.Companion.STRING_KEY2
import com.example.movielist.model.Values.Companion.isFlagged
import com.example.movielist.model.Values.Companion.watched
import kotlinx.android.synthetic.main.activity_edit_movie.*

class EditMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)
        var oldMovieName: String? = intent.getStringExtra(STRING_KEY2)
        var textViewID: Int = intent.getIntExtra(INT_KEY, INT_TO_DEFAULT)

        if (oldMovieName != null) {
            edit_text.setText(oldMovieName, TextView.BufferType.EDITABLE)
        }

        button_save.setOnClickListener {

            if (oldMovieName != null) {
                var intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra(INT_KEY, textViewID)
                intent.putExtra(STRING_KEY2, edit_text.text.toString())
                setResult(Activity.RESULT_OK, intent)
                Log.i("FindMe", "Found 1")
            } else {
                var movieName = edit_text.text.toString()
                var intent = Intent(this, MovieListActivity::class.java)
                intent.putExtra(STRING_KEY, movieName)
                intent.putExtra(INT_KEY, textViewID)
                setResult(Activity.RESULT_OK, intent)
                Log.i("FindMe", "Found 2")
            }
            finish()
        }

        button_remove.setOnClickListener {
            Log.i("FindMe", "Found button")
            var intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra(INT_KEY, textViewID)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        toggle_watched.setOnCheckedChangeListener { _, isChecked ->
            watched = isChecked
        }

    }
}
