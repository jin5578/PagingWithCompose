package com.example.presentation.model

import com.example.domain.model.Location

data class LocationUIModel(
    val placeId: String,
    val addressName: String,
    val placeName: String,
)

fun Location.toUIModel(): LocationUIModel {
    return LocationUIModel(
        placeId = this.placeId,
        addressName = this.addressName,
        placeName = this.placeName,
    )
}

fun LocationUIModel.toDomainModel(): Location {
    return Location(
        placeId = this.placeId,
        addressName = this.addressName,
        placeName = this.placeName,
    )
}