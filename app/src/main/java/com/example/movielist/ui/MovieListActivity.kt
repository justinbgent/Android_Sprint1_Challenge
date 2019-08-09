package com.example.movielist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import com.example.movielist.R
import kotlinx.android.synthetic.main.activity_main.*

class MovieListActivity : AppCompatActivity() {

    companion object{
        const val  STRING_KEY = "STRING_KEY"
        var counter = 0
    }

    fun addMovie(text: String, id: Int): TextView{
        var movie = TextView(this)
        movie.text = text
        movie.textSize = 16f
        movie.id = id
        movie.height = 80
        movie.width = ViewGroup.LayoutParams.MATCH_PARENT

        movie.setOnClickListener{
            var intent = Intent(this, EditMovieActivity::class.java)
            intent.putExtra(STRING_KEY, text)
        }
        return movie
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_movie.setOnClickListener {
            var intent = Intent(this, EditMovieActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val stringData: String = intent.getStringExtra(STRING_KEY) ?:"No Data"
        if(!stringData.equals("No Data")){
            addMovie(stringData, counter++)
        }
    }
}

