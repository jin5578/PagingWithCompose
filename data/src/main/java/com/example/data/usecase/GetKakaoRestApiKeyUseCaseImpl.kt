package com.example.data.usecase

import com.example.data.datastore.KakaoDataStore
import com.example.domain.usecase.GetKakaoRestApiKeyUseCase
import javax.inject.Inject

class GetKakaoRestApiKeyUseCaseImpl @Inject constructor(
    private val kakaoDataStore: KakaoDataStore
) : GetKakaoRestApiKeyUseCase {
    override suspend fun invoke(): String? {
        return kakaoDataStore.getRestApiKey()
    }
}