package com.example.marvelappremastered.presentation.core

class Constants {
    companion object {
        internal const val BASE_URL_MARVEL = "https://gateway.marvel.com"
        internal const val BASE_URL_NEWS = "https://newsapi.org"

        internal const val MARVEL_APP_SHARED_PREFERENCES = "marvel.app.shared.preferences"

        internal const val VISA = '4'
        internal const val MASTER_CARD = '5'

        internal const val ERROR_CARD_LENGTH = "the length of the card must be 16"
        internal const val ERROR_CV_LENGTH = "the length of the cv must be 3"
        internal const val ERROR_CARD = "incorrect card"
        internal const val ERROR_DATE = "incorrect date"
        internal const val ERROR_MONTH = "the month can\\'t be more than 12"
        internal const val ERROR_VALID = "your card is not valid"
    }
}