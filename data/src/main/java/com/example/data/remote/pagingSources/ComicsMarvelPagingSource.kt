package com.example.data.remote.pagingSources

import com.example.data.utils.base.paging.BaseMarvelPagingSource
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.remote.dtos.ComicDto
import com.example.domain.model.ComicModel

class ComicsMarvelPagingSource(private val apiService: MarvelApi) : BaseMarvelPagingSource<ComicDto, ComicModel>({
    apiService.getComics(offset = it)
    }
)
