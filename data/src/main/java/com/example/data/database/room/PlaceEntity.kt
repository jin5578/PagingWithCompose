package com.example.data.database.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Location

@Entity(tableName = "place")
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,
    @ColumnInfo(name = "placeId")
    val placeId: String,
    @ColumnInfo(name = "placeName")
    val placeName: String,
    @ColumnInfo(name = "addressName")
    val addressName: String
)

fun Location.toEntity(): PlaceEntity {
    return PlaceEntity(
        placeId = this.placeId,
        placeName = this.placeName,
        addressName = this.addressName
    )
}