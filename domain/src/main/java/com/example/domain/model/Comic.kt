package com.example.domain.model

data class Comic(
    val id: Int = DEFAULT_COMIC_ID,
    val title: String = "",
    val image: String = "",
) {
    companion object {
        private const val DEFAULT_COMIC_ID = 0
    }
}