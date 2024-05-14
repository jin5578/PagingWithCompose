package com.example.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(placeEntity: PlaceEntity)

    @Query("select placeId from place")
    suspend fun findPlaceIdList(): List<String>

    @Query("delete from place where placeId == :placeId")
    suspend fun deletePlace(placeId: String)
}