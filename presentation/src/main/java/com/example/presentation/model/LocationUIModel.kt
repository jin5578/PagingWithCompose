package com.example.presentation.model

import com.example.domain.model.Location

data class LocationUIModel(
    val id: String,
    val addressName: String,
    val placeName: String
)

fun Location.toUIModel(): LocationUIModel {
    return LocationUIModel(
        id = this.id,
        addressName = this.addressName,
        placeName = this.placeName
    )
}