package com.example.data.remote.dtos

import com.example.data.core.DataMapper
import com.example.domain.model.ComicModel
import com.example.domain.model.ThumbnailModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicDto(
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: ThumbnailDto? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    val id: Int,
) : DataMapper<ComicModel> {
    override fun mapToDomain() = ComicModel(
        title = title,
        thumbnail = thumbnail?.mapToDomain(),
        description = description,
        id = id
    )
}

data class ThumbnailDto(
    @SerializedName("path")
    @Expose
    var path: String? = null,
    @SerializedName("extension")
    @Expose
    var extension: String? = null,
) : DataMapper<ThumbnailModel> {
    override fun mapToDomain() = ThumbnailModel(
        path = path,
        extension = extension
    )
}