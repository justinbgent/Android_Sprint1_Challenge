package com.example.movielist.model

import java.io.Serializable

class Values {

    companion object {
        var onlyOnce = true
        var watched = false
        var movieList = mutableListOf<Data>()
        var isFlagged = arrayListOf<Boolean>()
        const val STRING_KEY = "STRING_KEY"
        const val STRING_KEY2 = "STRING_KEY2"
        const val INT_KEY = "RETRIEVE INT"
        const val TITLE_REQUEST_KEY = 3
        const val EDIT_TEXT_KEY = 1
        const val INT_TO_DEFAULT = -1
        const val NO_VALUES = 0
    }

}

class Data(var movieTitle: String) : Serializable {
    var movie: String = movieTitle
}

