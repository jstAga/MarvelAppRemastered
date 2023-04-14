package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Comic
import com.example.domain.model.ComicModel
import com.example.domain.result.Resource
import kotlinx.coroutines.flow.Flow


interface ComicsRepository {

    fun getComics() : Flow<PagingData<ComicModel>>

    fun createComic(comic : Comic) : Flow<Resource<Unit>>

    fun deleteComic(comic : Comic) : Flow<Resource<Unit>>
}