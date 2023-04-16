package com.example.data.repository

import com.example.data.core.base.BaseRepository
import com.example.data.local.room.ComicsDao
import com.example.data.local.room.entities.toComicEntity
import com.example.domain.model.Comic
import com.example.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(private val comicsDao: ComicsDao) : RoomRepository, BaseRepository() {

    override fun createComic(comic: Comic) = doRequest { comicsDao.createComic(comic.toComicEntity()) }

    override fun readComics() = doRequest { comicsDao.readComics().map { it.mapToDomain() } }

    override fun updateComic(comic: Comic) = doRequest { comicsDao.updateComic(comic.toComicEntity()) }

    override fun deleteComic(comic: Comic) = doRequest { comicsDao.deleteComic(comic.toComicEntity()) }
}