package com.example.data.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        internal const val PAGING_LIMIT = "20"

        // marvel api
        private const val MARVEL_PRIVATE_KEY = "e96dba542132bc92b4436e34dd50455ffd3f4b4f"
        internal const val MARVEL_API_KEY = "3e794e5ed62fd1f9a317dde6718e63da"
        internal val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        internal fun hash(): String {
            val input = "$timeStamp$MARVEL_PRIVATE_KEY$MARVEL_API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        // news api
        internal const val NEWS_API_KEY = "1b3b06a8b6614f199a62a662a0666e46"
        internal const val NEWS_QUERY = "marvel"
        internal const val NEWS_LANGUAGE = "ru"

        // sharedPref keys
        internal const val CREDIT_CARD = "credit.card"
        internal const val VALID_THRU = "valid.thru"
        internal const val CV = "cv"

        // imdb api
        internal const val IMDB_API_KEY = "522d966999msha190ba44d1b26c6p169d5cjsn8794069ff072"
        internal const val IMDB_HOST = "imdb8.p.rapidapi.com"
        internal const val IMDB_RUNTIME = 80
        internal const val IMDB_USER_RATING = 7
        internal const val IMDB_KEYWORD = "marvel"
        internal const val IMDB_TYPE = "movie"
        internal const val IMDB_TITLE = "batman"
        internal const val IMDB_COUNTRY = "us"
    }
}