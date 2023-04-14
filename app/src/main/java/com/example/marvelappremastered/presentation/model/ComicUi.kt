package com.example.marvelappremastered.presentation.model

import com.example.data.core.base.IBaseDiffModel
import com.example.domain.model.Comic
import com.example.domain.model.ComicModel

data class ComicUi(
    var title: String? = null,
    val image: String? = null,
    var description: String? = null,
    override val id: Int,
): IBaseDiffModel<Int>

fun ComicModel.toUI() = ComicUi(
    title = title,
    image = this.thumbnail?.path + "." + this.thumbnail?.extension,
    description = description,
    id = id
)

fun Comic.toUI() = ComicUi(
    title = title,
    image = image,
    id = id
)

fun ComicUi.toDomain() = Comic(
    title = title.toString(),
    image = image.toString(),
    id = id
)