package com.example.domain.usecase.room

import com.example.domain.model.Location

interface InsertPlaceUseCase {
    suspend operator fun invoke(
        location: Location
    ): Result<Unit>
}