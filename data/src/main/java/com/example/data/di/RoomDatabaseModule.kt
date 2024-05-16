package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RoomDatabaseModule {
    companion object {
        @Provides
        fun provideRoomDatabase(
            context: Context
        ): RoomDatabase =
            Room.databaseBuilder(context, RoomDatabase::class.java, "ROOMDB")
                .fallbackToDestructiveMigration()
                .build()
    }
}