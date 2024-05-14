package com.example.data.usecase.system

import com.example.data.database.datastore.KakaoDataStore
import com.example.domain.usecase.system.SetKakaoRestApiKeyUseCase
import javax.inject.Inject

class SetKakaoRestApiKeyUseCaseImpl @Inject constructor(
    private val kakaoDataStore: KakaoDataStore
) : SetKakaoRestApiKeyUseCase {
    override suspend fun invoke(restApiKey: String): Result<Unit> = runCatching {
        kakaoDataStore.setRestApiKey(restApiKey)
    }
}