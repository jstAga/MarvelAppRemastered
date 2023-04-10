package com.example.data.remote

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val LIMIT = "20"

        private const val MARVEL_PRIVATE_KEY = "e96dba542132bc92b4436e34dd50455ffd3f4b4f"
        internal const val MARVEL_API_KEY = "3e794e5ed62fd1f9a317dde6718e63da"
        internal const val BASE_URL_MARVEL = "https://gateway.marvel.com"

        fun hash(): String{
            val input = "$timeStamp${MARVEL_PRIVATE_KEY}${MARVEL_API_KEY}"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}