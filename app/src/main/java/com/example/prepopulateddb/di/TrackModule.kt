package com.example.prepopulateddb.di

import android.content.Context
import androidx.room.Room
import com.example.prepopulateddb.Database.TrackDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TrackModule {

    @Provides
    @Singleton
    fun provideTrackDatabase(@ApplicationContext context: Context) : TrackDatabase {
        return Room.databaseBuilder(context.applicationContext, TrackDatabase::class.java, "TrackDB")
            .createFromAsset("database/ParcelTrack.db")
            .build()
    }

}