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
import com.example.movielist.model.Values.Companion.watched




class MovieListActivity : AppCompatActivity() {

//    private var counter = 0

//    private fun formatTextViews(text: String, id: Int): TextView {
//        var movie = TextView(this)
//        movie.text = text
//        movie.textSize = 16f
//        movie.id = id
//        movie.height = 80
//        movie.width = ViewGroup.LayoutParams.MATCH_PARENT
//
//        if (watched){
//            movie.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
//        }
//        watched = false
//
//        movie.setOnClickListener {
//            var intent = Intent(this, EditMovieActivity::class.java)
//            intent.putExtra(INT_KEY, movie.id)
//            intent.putExtra(STRING_KEY2, movieList[id].movie)
//            startActivityForResult(intent, EDIT_TEXT_KEY)
//        }
//        return movie
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.movielist.R.layout.activity_main)

        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))
        movieList.add(Data("Tarzan"))

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

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        if (requestCode == TITLE_REQUEST_KEY && resultCode == Activity.RESULT_OK) {
//            var dataReceived = data!!.getStringExtra(STRING_KEY)
//            movieList.add(counter, Data(dataReceived))
//            ll_parent.addView(formatTextViews(dataReceived, counter++))
//        }
//        if (requestCode == EDIT_TEXT_KEY && resultCode == Activity.RESULT_OK) {
//            var intData: Int = data!!.getIntExtra(INT_KEY, INT_TO_DEFAULT)
//            var textView = findViewById<TextView>(intData)
//            var stringData: String? = data.getStringExtra(STRING_KEY2)
//
//            if (stringData != null) {
//                movieList[intData] = Data(stringData)
//                textView.text = movieList[intData].movie
//                if (watched){
//                    textView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
//                }else{
//                    textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
//                }
//                watched = false
//                Log.i("FindMe", "Found $intData")
//                Log.i("FindMe", "Found $stringData")
//            }
//            if (intData != INT_TO_DEFAULT && stringData == null) {
//                Log.i("FindMe", "Found Jackpot")
//                movieList.removeAt(intData)
//                counter--
//                ll_parent.removeAllViews()
//                for (i in 0 until movieList.size) {
//                    ll_parent.addView(formatTextViews(movieList[i].movie, i))
//                }
//            }
//        }
//    }
}