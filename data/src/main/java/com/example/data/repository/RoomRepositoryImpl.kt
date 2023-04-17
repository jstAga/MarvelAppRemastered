package com.example.data.repository

import androidx.paging.*
import com.example.data.utils.base.BaseRepository
import com.example.data.local.room.dao.ComicsDao
import com.example.data.local.room.entities.toComicEntity
import com.example.data.local.room.pagingSources.ComicsPagingSource
import com.example.domain.model.Comic
import com.example.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(private val comicsDao: ComicsDao) : RoomRepository,
    BaseRepository() {

    override fun createComic(comic: Comic) = doRequest { comicsDao.createComic(comic.toComicEntity()) }
    override fun readComics(): Flow<PagingData<Comic>> {
        return Pager(
            PagingConfig(pageSize = 20)
        ) {
            ComicsPagingSource(comicsDao)
        }.flow
    }

    override fun updateComic(comic: Comic) = doRequest { comicsDao.updateComic(comic.toComicEntity()) }

    override fun deleteComic(comic: Comic) = doRequest { comicsDao.deleteComic(comic.toComicEntity()) }
}