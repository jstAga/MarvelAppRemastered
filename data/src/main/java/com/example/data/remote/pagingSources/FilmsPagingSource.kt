package com.example.data.remote.pagingSources

import com.example.data.remote.apiServices.ImdbApi
import com.example.data.remote.dtos.FilmDto
import com.example.data.utils.base.paging.BasePagingSource
import com.example.domain.model.FilmModel

class FilmsPagingSource(private val apiService: ImdbApi) :
    BasePagingSource<FilmDto, FilmModel>({
        apiService.getFilms(paginationKey = it)
    })