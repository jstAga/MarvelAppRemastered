package com.example.data.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.room.entities.ComicEntity

interface ComicsDao {

    @Insert
    suspend fun createComic(comic : ComicEntity)

    @Query("SELECT * FROM comic")
    suspend fun readComics(comic : ComicEntity)

    @Update
    suspend fun updateComic(comic : ComicEntity)

    @Delete
    suspend fun deleteComic(comic : ComicEntity)
}