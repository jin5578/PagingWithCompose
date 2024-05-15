package com.example.data.usecase.room

import com.example.data.database.room.RoomDatabase
import com.example.domain.usecase.room.DeletePlaceUseCase
import javax.inject.Inject

class DeletePlaceUseCaseImpl @Inject constructor(
    private val roomDatabase: RoomDatabase
) : DeletePlaceUseCase {
    override suspend fun invoke(placeId: String): Result<Unit> = runCatching {
        roomDatabase.placeDao().deletePlace(placeId)
    }
}