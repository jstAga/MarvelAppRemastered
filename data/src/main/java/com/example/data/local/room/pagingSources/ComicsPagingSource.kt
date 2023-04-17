package com.example.data.local.room.pagingSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.local.room.dao.ComicsDao
import com.example.domain.model.Comic

class ComicsPagingSource(private val dao: ComicsDao) :
    PagingSource<Int, Comic>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comic> {
        val position = params.key ?: 0

        return try {
            val response = dao.readComics(params.loadSize, position * params.loadSize)
            val responseData = mutableListOf<Comic>()
            responseData.addAll(response.map { it.mapToDomain() })

            LoadResult.Page(
                data = responseData,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (responseData.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Comic>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}