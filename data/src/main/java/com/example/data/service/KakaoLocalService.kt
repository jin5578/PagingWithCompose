package com.example.data.service

import com.example.data.model.dto.KakaoLocalDocumentDto
import com.example.data.model.dto.KakaoLocalResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoLocalService {
    @GET("v2/local/search/keyword.json")
    suspend fun searchKeyword(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): KakaoLocalResponseDto<KakaoLocalDocumentDto>
}