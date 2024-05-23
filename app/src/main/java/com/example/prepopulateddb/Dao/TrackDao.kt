package com.example.prepopulateddb.Dao

import androidx.room.Dao
import androidx.room.Query
import com.example.prepopulateddb.Models.Parcel

@Dao
interface TrackDao {

    @Query("Select * from Parcel")
    suspend fun getAllParcel() : MutableList<Parcel>
}