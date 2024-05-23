package com.example.prepopulateddb.Models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Parcel")
data class Parcel(
    @PrimaryKey
    val event_id: Int,
    @NonNull
    val tracking_num: Int,
    @NonNull
    val status: String,
    @NonNull
    val date_time: Int,
    @NonNull
    val location: String,
)