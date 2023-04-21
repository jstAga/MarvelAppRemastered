package com.example.domain.model


data class FilmModel(
    var filmID: String? = null,
    val image: ImageModel? = null,
    val title: String? = null,
)

data class ImageModel(
    val url: String,
)