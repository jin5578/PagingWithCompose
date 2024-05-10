package com.example.data.usecase

import com.example.data.datastore.KakaoDataStore
import com.example.domain.usecase.SetKakaoRestApiKeyUseCase
import javax.inject.Inject

class SetKakaoRestApiKeyUseCaseImpl @Inject constructor(
    private val kakaoDataStore: KakaoDataStore
) : SetKakaoRestApiKeyUseCase {
    override suspend fun invoke(restApiKey: String) {
        kakaoDataStore.setRestApiKey(restApiKey)
    }
}