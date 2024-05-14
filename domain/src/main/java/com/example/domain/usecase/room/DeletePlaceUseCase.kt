package com.example.domain.usecase.room

interface DeletePlaceUseCase {
    suspend operator fun invoke(placeId: String): Result<Unit>
}