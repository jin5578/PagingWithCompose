package com.example.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KakaoLocalResponseDto<T>(
    @SerialName("meta")
    val meta: KeywordMetaDto,
    @SerialName("documents")
    val documentList: List<T>
)