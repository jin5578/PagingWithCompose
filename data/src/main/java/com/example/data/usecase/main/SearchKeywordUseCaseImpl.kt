package com.example.data.usecase.main

import com.example.data.model.dto.toDomainModel
import com.example.data.service.KakaoLocalService
import com.example.domain.model.Location
import com.example.domain.usecase.main.SearchKeywordUseCase
import javax.inject.Inject

class SearchKeywordUseCaseImpl @Inject constructor(
    private val kakaoLocalService: KakaoLocalService
) : SearchKeywordUseCase {
    override suspend fun invoke(
        query: String,
        page: Int,
        size: Int
    ): Result<List<Location>> = runCatching {
        kakaoLocalService.searchKeyword(query, page, size).documentList.map { dto ->
            dto.toDomainModel()
        }
    }
}