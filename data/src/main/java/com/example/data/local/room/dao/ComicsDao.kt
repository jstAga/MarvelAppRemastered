package com.example.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.room.entities.ComicEntity

@Dao
interface ComicsDao {

    @Insert
    suspend fun createComic(comicEntity: ComicEntity)

    @Query("SELECT * FROM comic ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun readComics(limit: Int, offset: Int): List<ComicEntity>

    @Update
    suspend fun updateComic(comicEntity: ComicEntity)

    @Delete
    suspend fun deleteComic(comicEntity: ComicEntity)
}