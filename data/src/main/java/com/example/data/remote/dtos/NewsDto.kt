package com.example.data.remote.dtos

import com.example.data.utils.base.DataMapper
import com.example.domain.model.NewsModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("publishedAt")
    @Expose
    val publishedAt: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String,
) : DataMapper<NewsModel> {
    override fun mapToDomain() = NewsModel(
        title = title,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )
}