package com.example.domain.usecase.main

import androidx.paging.PagingData
import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface SearchKeywordUseCase {
    suspend operator fun invoke(
        query: String
    ): Result<Flow<PagingData<Location>>>
}