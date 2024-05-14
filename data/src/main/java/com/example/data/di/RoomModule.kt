package com.example.data.di

import com.example.data.usecase.room.DeletePlaceUseCaseImpl
import com.example.data.usecase.room.FindPlaceIdListUseCaseImpl
import com.example.data.usecase.room.InsertPlaceUseCaseImpl
import com.example.domain.usecase.room.DeletePlaceUseCase
import com.example.domain.usecase.room.FindPlaceIdListUseCase
import com.example.domain.usecase.room.InsertPlaceUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RoomModule {
    @Binds
    abstract fun bindInsertPlaceUseCase(uc: InsertPlaceUseCaseImpl): InsertPlaceUseCase

    @Binds
    abstract fun bindFindPlaceIdListUseCase(uc: FindPlaceIdListUseCaseImpl): FindPlaceIdListUseCase

    @Binds
    abstract fun bindDeletePlaceUseCase(uc: DeletePlaceUseCaseImpl): DeletePlaceUseCase
}