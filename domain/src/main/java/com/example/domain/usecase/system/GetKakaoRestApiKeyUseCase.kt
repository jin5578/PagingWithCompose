package com.example.domain.usecase.system

interface GetKakaoRestApiKeyUseCase {
    suspend operator fun invoke(): String?
}