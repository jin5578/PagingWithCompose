package com.example.domain.usecase.system

interface SetKakaoRestApiKeyUseCase {
    suspend operator fun invoke(restApiKey: String): Result<Unit>
}