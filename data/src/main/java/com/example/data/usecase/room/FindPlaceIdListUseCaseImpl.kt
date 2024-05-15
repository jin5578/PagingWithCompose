package com.example.data.usecase.room

import com.example.data.database.room.RoomDatabase
import com.example.domain.usecase.room.FindPlaceIdListUseCase
import javax.inject.Inject

class FindPlaceIdListUseCaseImpl @Inject constructor(
    private val roomDatabase: RoomDatabase
) : FindPlaceIdListUseCase {
    override suspend fun invoke(): Result<List<String>> = runCatching {
        roomDatabase.placeDao().findPlaceIdList()
    }
}