package com.example.movielist.model

import android.widget.TextView
import java.io.Serializable

class Values {

    companion object {
        var watched = false
        const val STRING_KEY = "STRING_KEY"
        const val STRING_KEY2 = "STRING_KEY2"
        const val INT_KEY = "RETRIEVE INT"
        const val TITLE_REQUEST_KEY = 3
        const val EDIT_TEXT_KEY = 1
        const val INT_TO_DEFAULT = -1
        var movieList = mutableListOf<Data>()
    }
}

class Data(var movieTitle: String) : Serializable {
    var movie: String = movieTitle
}