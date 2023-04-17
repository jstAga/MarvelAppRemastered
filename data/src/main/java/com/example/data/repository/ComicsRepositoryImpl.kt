package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.utils.base.BaseRepository
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.remote.pagingSources.ComicsMarvelPagingSource
import com.example.domain.model.ComicModel
import com.example.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(private val apiService: MarvelApi) :
    BaseRepository(), ComicsRepository {

    override fun getComics(): Flow<PagingData<ComicModel>> {
        return doPagingRequest(
            ComicsMarvelPagingSource(
                apiService = apiService
            ), pageSize = 20
        )
    }
}