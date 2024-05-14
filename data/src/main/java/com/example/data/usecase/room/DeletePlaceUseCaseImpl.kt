package com.example.data.usecase.room

import com.example.data.database.room.PlaceDao
import com.example.domain.usecase.room.DeletePlaceUseCase
import javax.inject.Inject

class DeletePlaceUseCaseImpl @Inject constructor(
    private val dao: PlaceDao
) : DeletePlaceUseCase {
    override suspend fun invoke(placeId: String): Result<Unit> = runCatching {
        dao.deletePlace(placeId)
    }
}