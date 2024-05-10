package com.example.domain.usecase

interface GetKakaoRestApiKeyUseCase {
    suspend operator fun invoke(): String?
}