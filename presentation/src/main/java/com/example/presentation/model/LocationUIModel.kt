package com.example.presentation.model

import com.example.domain.model.Location

data class LocationUIModel(
    val addressName: String,
    val placeName: String
)

fun Location.toUIModel(): LocationUIModel {
    return LocationUIModel(
        addressName = this.addressName,
        placeName = this.placeName
    )
}