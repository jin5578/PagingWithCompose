package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.database.room.PlaceDao
import com.example.data.database.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(
        application: Application
    ): RoomDatabase =
        Room.databaseBuilder(application, RoomDatabase::class.java, "ROOMDB")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePlaceDao(database: RoomDatabase): PlaceDao =
        database.placeDao()
}