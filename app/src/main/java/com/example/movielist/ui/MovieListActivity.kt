package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.movielist.R
import com.example.movielist.model.Data
import kotlinx.android.synthetic.main.activity_main.*

class MovieListActivity : AppCompatActivity() {

    var movieList = mutableListOf<Data>()

    companion object {
        const val STRING_KEY = "STRING_KEY"
        const val STRING_KEY2 = "STRING_KEY2"
        const val INT_KEY = "RETRIEVE INT"
        const val TITLE_REQUEST_KEY = 3
        const val EDIT_TEXT_KEY = 1
        var counter = 0
    }

        fun addToList(text: String, id: Int): TextView {
            var movie = TextView(this)
            movie.text = text
            movie.textSize = 16f
            movie.id = id
            movie.height = 80
            movie.width = ViewGroup.LayoutParams.MATCH_PARENT

            movie.setOnClickListener {
                var intent = Intent(this, EditMovieActivity::class.java)
                intent.putExtra(STRING_KEY, movie.id)
                intent.putExtra(STRING_KEY2, text)
                //movieList.removeAt(movie.id)
                //ll_parent.removeView(movie)
                startActivityForResult(intent, EDIT_TEXT_KEY)
            }
            return movie
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_movie.setOnClickListener {
            var intent = Intent(this, EditMovieActivity::class.java)
            startActivityForResult(intent, TITLE_REQUEST_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == TITLE_REQUEST_KEY && resultCode == Activity.RESULT_OK){
            var dataReceived: String = data!!.getStringExtra(STRING_KEY)
            movieList.add(counter, Data(dataReceived))
            ll_parent.addView(addToList(movieList[counter].movieTitle, counter++))
        }
        if(requestCode == EDIT_TEXT_KEY && resultCode == Activity.RESULT_OK){
            var dataStringReceived: String = data!!.getStringExtra(STRING_KEY2)
            var dataIntReceived: Int = data.getIntExtra(STRING_KEY, 11)
            movieList[dataIntReceived] = Data(dataStringReceived)
            findViewById<TextView>(dataIntReceived).text = dataStringReceived
        }
        //super.onActivityResult(requestCode, resultCode, data)
    }
}

