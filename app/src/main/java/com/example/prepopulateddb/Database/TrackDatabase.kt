package com.example.prepopulateddb.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prepopulateddb.Dao.TrackDao
import com.example.prepopulateddb.Models.Parcel

@Database(entities = [Parcel::class], version = 1, exportSchema = false)
abstract class TrackDatabase: RoomDatabase() {

    abstract fun trackDao() : TrackDao
}