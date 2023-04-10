package com.example.domain.model

data class ComicModel(
    var title: String? = null,
    var thumbnail: ThumbnailModel? = null,
    var description: String? = null,
    val id : Int
)

data class ThumbnailModel(
    var path: String? = null,
    var extension: String? = null,
)