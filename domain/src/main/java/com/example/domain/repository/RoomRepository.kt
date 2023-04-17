package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Comic
import com.example.domain.result.Resource
import kotlinx.coroutines.flow.Flow

interface RoomRepository {

    fun createComic(comic: Comic): Flow<Resource<Unit>>

     fun readComics() : Flow<PagingData<Comic>>

     fun updateComic(comic: Comic): Flow<Resource<Unit>>

    fun deleteComic(comic: Comic): Flow<Resource<Unit>>
}