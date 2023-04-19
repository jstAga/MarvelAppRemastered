package com.example.data.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        internal val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        internal const val PAGING_LIMIT = "20"

        private const val MARVEL_PRIVATE_KEY = "e96dba542132bc92b4436e34dd50455ffd3f4b4f"
        internal const val MARVEL_API_KEY = "3e794e5ed62fd1f9a317dde6718e63da"

        internal const val NEWS_API_KEY = "1b3b06a8b6614f199a62a662a0666e46"
        internal const val NEWS_QUERY = "marvel"
        internal const val NEWS_LANGUAGE = "ru"

        internal const val CREDIT_CARD = "credit.card"
        internal const val VALID_THRU = "valid.thru"
        internal const val CV = "cv"

        internal fun hash(): String {
            val input = "$timeStamp$MARVEL_PRIVATE_KEY$MARVEL_API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}