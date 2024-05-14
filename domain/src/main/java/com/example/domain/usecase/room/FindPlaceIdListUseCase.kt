package com.example.domain.usecase.room

interface FindPlaceIdListUseCase {
    suspend operator fun invoke(): Result<List<String>>
}