package com.example.data.usecase.room

import com.example.data.database.room.RoomDatabase
import com.example.data.database.room.toEntity
import com.example.domain.model.Location
import com.example.domain.usecase.room.InsertPlaceUseCase
import javax.inject.Inject

class InsertPlaceUseCaseImpl @Inject constructor(
    private val roomDatabase: RoomDatabase
) : InsertPlaceUseCase {
    override suspend fun invoke(location: Location): Result<Unit> = runCatching {
        val entity = location.toEntity()
        roomDatabase.placeDao().insertPlace(entity)
    }
}