package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.FilmModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getFilms() : Flow<PagingData<FilmModel>>
}