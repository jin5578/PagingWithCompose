package com.example.data.di

import com.example.data.usecase.GetKakaoRestApiKeyUseCaseImpl
import com.example.data.usecase.SetKakaoRestApiKeyUseCaseImpl
import com.example.domain.usecase.GetKakaoRestApiKeyUseCase
import com.example.domain.usecase.SetKakaoRestApiKeyUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SystemModule {
    @Binds
    abstract fun bindGetKakaoRestApiKeyUseCase(uc: GetKakaoRestApiKeyUseCaseImpl): GetKakaoRestApiKeyUseCase

    @Binds
    abstract fun bindSetKakaoRestApiKeyUseCase(uc: SetKakaoRestApiKeyUseCaseImpl): SetKakaoRestApiKeyUseCase
}