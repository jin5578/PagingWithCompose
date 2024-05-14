package com.example.data.usecase.room

import com.example.data.database.room.PlaceDao
import com.example.data.database.room.toEntity
import com.example.domain.model.Location
import com.example.domain.usecase.room.InsertPlaceUseCase
import javax.inject.Inject

class InsertPlaceUseCaseImpl @Inject constructor(
    private val dao: PlaceDao
) : InsertPlaceUseCase {
    override suspend fun invoke(location: Location): Result<Unit> = runCatching {
        val entity = location.toEntity()
        dao.insertPlace(entity)
    }
}