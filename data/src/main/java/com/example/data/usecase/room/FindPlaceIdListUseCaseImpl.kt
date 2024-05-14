package com.example.data.usecase.room

import com.example.data.database.room.PlaceDao
import com.example.domain.usecase.room.FindPlaceIdListUseCase
import javax.inject.Inject

class FindPlaceIdListUseCaseImpl @Inject constructor(
    private val dao: PlaceDao
) : FindPlaceIdListUseCase {
    override suspend fun invoke(): Result<List<String>> = runCatching {
        dao.findPlaceIdList()
    }
}