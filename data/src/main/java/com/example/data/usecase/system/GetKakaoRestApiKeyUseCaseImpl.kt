package com.example.data.usecase.system

import com.example.data.database.datastore.KakaoDataStore
import com.example.domain.usecase.system.GetKakaoRestApiKeyUseCase
import javax.inject.Inject

class GetKakaoRestApiKeyUseCaseImpl @Inject constructor(
    private val kakaoDataStore: KakaoDataStore
) : GetKakaoRestApiKeyUseCase {
    override suspend fun invoke(): String? {
        return kakaoDataStore.getRestApiKey()
    }
}