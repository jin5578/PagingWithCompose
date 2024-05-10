package com.example.domain.usecase

interface SetKakaoRestApiKeyUseCase {
    suspend operator fun invoke(restApiKey: String)
}