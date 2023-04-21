package com.example.marvelappremastered.presentation.model

import com.example.data.utils.base.IBaseDiffModel
import com.example.domain.model.FilmModel

data class FilmUi(
    var filmID: String? = null,
    val image: String? = null,
    val title: String? = null,
    override val id: Int,
) : IBaseDiffModel<Int>

fun FilmModel.toUI() = FilmUi(
    filmID = filmID,
    image = this.image?.url,
    title = title,
    id = 0
)