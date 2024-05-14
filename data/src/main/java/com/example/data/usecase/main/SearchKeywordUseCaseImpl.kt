package com.example.data.usecase.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.paging.LocationPagingSource
import com.example.data.service.KakaoLocalService
import com.example.domain.model.Location
import com.example.domain.usecase.main.SearchKeywordUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchKeywordUseCaseImpl @Inject constructor(
    private val kakaoLocalService: KakaoLocalService,
) : SearchKeywordUseCase {
    override suspend fun invoke(
        query: String,
    ): Result<Flow<PagingData<Location>>> = runCatching {
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                LocationPagingSource(
                    kakaoLocalService,
                    query,
                )
            }
        ).flow
    }
}