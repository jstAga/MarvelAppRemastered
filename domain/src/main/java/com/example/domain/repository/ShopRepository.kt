package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.ComicModel
import kotlinx.coroutines.flow.Flow


interface ShopRepository {

    fun getComics() : Flow<PagingData<ComicModel>>
}