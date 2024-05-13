package com.example.domain.usecase.main

import com.example.domain.model.Location

interface SearchKeywordUseCase {
    suspend operator fun invoke(
        query: String,
        page: Int,
        size: Int
    ): Result<List<Location>>
}