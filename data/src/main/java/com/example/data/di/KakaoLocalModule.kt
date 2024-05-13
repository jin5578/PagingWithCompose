package com.example.data.di

import com.example.data.usecase.main.SearchKeywordUseCaseImpl
import com.example.domain.usecase.main.SearchKeywordUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KakaoLocalModule {
    @Binds
    abstract fun bindSearchKeywordUseCase(uc: SearchKeywordUseCaseImpl): SearchKeywordUseCase
}