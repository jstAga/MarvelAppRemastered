package com.example.data.remote.dtos

import com.example.data.utils.base.DataMapper
import com.example.domain.model.FilmModel
import com.example.domain.model.ImageModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id")
    @Expose
    var filmID: String? = null,
    @Expose
    @SerializedName("image")
    val image: ImageDto? = null,
    @Expose
    @SerializedName("title")
    val title: String? = null,
) : DataMapper<FilmModel>{
    override fun mapToDomain() = FilmModel(
        filmID = filmID,
        image = image?.mapToDomain(),
        title = title,
    )
}

data class ImageDto(
    @SerializedName("url")
    @Expose
    val url: String,
): DataMapper<ImageModel> {
    override fun mapToDomain() = ImageModel(
        url = url
    )
}