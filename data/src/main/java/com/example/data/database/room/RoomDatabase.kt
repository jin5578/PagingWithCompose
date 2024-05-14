package com.example.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PlaceEntity::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}