package com.example.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KeywordMetaDto(
    @SerialName("pageable_count")
    val pageableCount: Int,
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("is_end")
    val isEnd: Boolean
)