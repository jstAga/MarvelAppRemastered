package com.example.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.core.DataMapper
import com.example.domain.model.Comic


@Entity(tableName = "comic")
data class ComicEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
) : DataMapper<Comic> {
    override fun mapToDomain() = Comic(
        id = id,
        title = title,
        image = image
    )
}

fun Comic.toComicEntity() = ComicEntity(
    id = id,
    title = title,
    image = image
)