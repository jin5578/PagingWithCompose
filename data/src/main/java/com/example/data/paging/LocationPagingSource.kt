package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.model.dto.toDomainModel
import com.example.data.service.KakaoLocalService
import com.example.domain.model.Location
import javax.inject.Inject

class LocationPagingSource @Inject constructor(
    private val kakaoLocalService: KakaoLocalService,
    private val query: String,
) : PagingSource<Int, Location>() {
    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        val position = params.key ?: START_INDEX

        val keywordResponse = kakaoLocalService.searchKeyword(
            query = query,
            page = position,
            size = PARAMS_SIZE
        )

        val locationList = keywordResponse.documentList
        return LoadResult.Page(
            data = locationList.map { it.toDomainModel() },
            prevKey = if (position == START_INDEX) null else position - 1,
            nextKey = if (keywordResponse.meta.isEnd) null else position + 1
        )
    }

    companion object {
        const val START_INDEX = 1
        const val PARAMS_SIZE = 15
    }
}