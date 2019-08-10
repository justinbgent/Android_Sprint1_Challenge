package com.example.movielist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import com.example.movielist.R
import com.example.movielist.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Paint
import com.example.movielist.model.Values.Companion.EDIT_TEXT_KEY
import com.example.movielist.model.Values.Companion.INT_KEY
import com.example.movielist.model.Values.Companion.INT_TO_DEFAULT
import com.example.movielist.model.Values.Companion.STRING_KEY
import com.example.movielist.model.Values.Companion.STRING_KEY2
import com.example.movielist.model.Values.Companion.TITLE_REQUEST_KEY
import com.example.movielist.model.Values.Companion.movieList


class MovieListActivity : AppCompatActivity() {


    private var counter = 0


    private fun formatTextViews(text: String, id: Int): TextView {
        var movie = TextView(this)
        movie.text = text
        movie.textSize = 16f
        movie.id = id
        movie.height = 80
        movie.width = ViewGroup.LayoutParams.MATCH_PARENT

        movie.setPaintFlags(movie.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)

        movie.setOnClickListener {
            var intent = Intent(this, EditMovieActivity::class.java)
            intent.putExtra(INT_KEY, movie.id)
            intent.putExtra(STRING_KEY2, movieList[id].movie)
            //movieList.removeAt(movie.id)
            //ll_parent.removeView(movie)
            startActivityForResult(intent, EDIT_TEXT_KEY)
        }
        return movie
    }

//    private fun displayTextViews(textView: TextView, id: Int){
//        textView.setOnClickListener {
//            var intent = Intent(this, EditMovieActivity::class.java)
//            intent.putExtra(INT_KEY, textView.id)
//            intent.putExtra(STRING_KEY2, movieList[id].movie)
//            //movieList.removeAt(movie.id)
//            //ll_parent.removeView(movie)
//            startActivityForResult(intent, EDIT_TEXT_KEY)
//        }
//    }

//    private fun displayTextViews(textView: TextView, toRemove: Boolean, toEdit: Boolean) {
//        if (!toRemove && !toEdit) {
//            movieTitles.add(textView)
//        }
//        if (toRemove) {
//            for (i in 0 until movieTitles.size) {
//                if (movieTitles[i].id == textView.id){
//                    movieTitles.remove(movieTitles[i])
//                }
//            }
//        }
//        if (toEdit){
//            for (i in 0 until movieTitles.size) {
//                if (movieTitles[i].id == textView.id){
//                    movieTitles[i].text = textView.text
//                }
//            }
//        }
//
//        ll_parent.removeAllViews()
//        for (i in 0 until movieTitles.size) {
//            ll_parent.addView(movieTitles[i])
//        }
//    }
//
//    private fun displayTextViews(textViewID: Int, toRemove: Boolean) {
//        if (toRemove) {
//            for (i in 0 until movieTitles.size) {
//                if (movieTitles[i].id == textViewID) {
//                    movieTitles.remove(movieTitles[i])
//                }
//            }
//        }
//        ll_parent.removeAllViews()
//        for (i in 0 until movieTitles.size) {
//            ll_parent.addView(movieTitles[i])
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_movie.setOnClickListener {
            var intent = Intent(this, EditMovieActivity::class.java)
            startActivityForResult(intent, TITLE_REQUEST_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        if (requestCode == TITLE_REQUEST_KEY && resultCode == Activity.RESULT_OK) {
            var dataReceived: String = data!!.getStringExtra(STRING_KEY)
            movieList.add(counter, Data(dataReceived))
            ll_parent.addView(formatTextViews(dataReceived, counter++))
            //displayTextViews(formatTextViews(dataReceived, counter++), false, false)

        }
        if (requestCode == EDIT_TEXT_KEY && resultCode == Activity.RESULT_OK) {
            var intData: Int = data!!.getIntExtra(INT_KEY, INT_TO_DEFAULT)
            var textViewID = findViewById<TextView>(intData)
            var stringData: String? = data.getStringExtra(STRING_KEY2)

            if (stringData != null) {
                movieList[intData] = Data(stringData)
                textViewID.text = movieList[intData].movie
                //displayTextViews(formatTextViews(stringData, intData), false, true)
                Log.i("FindMe", "Found $intData")
                Log.i("FindMe", "Found $stringData")
            }
            if (intData != INT_TO_DEFAULT && stringData == null) {
                Log.i("FindMe", "Found Jackpot")
                //displayTextViews(intData, true)
                movieList.removeAt(intData)
                counter--
                ll_parent.removeAllViews()
                for (i in 0 until movieList.size) {
                    ll_parent.addView(formatTextViews(movieList[i].movie, i))
                }
            }
        }

//        movieTitles.add(formatTextViews(movieList[counter].movie, counter++))
//        for(i in 0 until movieTitles.size -1){
//            ll_parent.addView(movieTitles[i])
//        }
    }
}

