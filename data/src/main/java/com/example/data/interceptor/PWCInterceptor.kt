package com.example.data.interceptor

import com.example.domain.usecase.system.GetKakaoRestApiKeyUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class PWCInterceptor @Inject constructor(
    private val getKakaoRestApiKeyUseCase: GetKakaoRestApiKeyUseCase
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val restApiKey = runBlocking { getKakaoRestApiKeyUseCase() }
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    if (restApiKey.isNullOrEmpty()) {
                        this
                    } else {
                        this.addHeader("Authorization", restApiKey)
                    }
                }
                .build()
        )
    }
}
