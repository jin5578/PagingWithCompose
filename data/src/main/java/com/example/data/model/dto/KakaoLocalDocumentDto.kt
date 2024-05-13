package com.example.data.model.dto

import com.example.domain.model.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KakaoLocalDocumentDto(
    @SerialName("address_name")
    val addressName: String,
    @SerialName("road_address_name")
    val roadAddressName: String,
    @SerialName("place_name")
    val placeName: String,
)

fun KakaoLocalDocumentDto.toDomainModel(): Location {
    val addressName = this.roadAddressName.ifEmpty { this.addressName }

    return Location(
        addressName = addressName,
        placeName = this.placeName
    )
}