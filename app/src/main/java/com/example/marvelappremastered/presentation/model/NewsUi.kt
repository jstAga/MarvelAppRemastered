package com.example.marvelappremastered.presentation.model

import com.example.data.utils.base.IBaseDiffModel
import com.example.domain.model.NewsModel

data class NewsUi(
    val title: String? = null,
    val publishedAt: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    override val id: Int? = null,
) : IBaseDiffModel<Int?>

fun NewsModel.toUi() = NewsUi(
    title = title,
    publishedAt = publishedAt,
    url = url,
    urlToImage = urlToImage,
)