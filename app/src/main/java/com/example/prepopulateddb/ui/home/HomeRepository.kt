package com.example.prepopulateddb.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.prepopulateddb.Database.TrackDatabase
import com.example.prepopulateddb.Models.Parcel
import com.example.prepopulateddb.Utils.DataHandler
import javax.inject.Inject

class HomeRepository @Inject constructor(private val trackDatabase: TrackDatabase) {

    private val _trackLiveData = MutableLiveData<DataHandler<MutableList<Parcel>>>()
    val trackList get() = _trackLiveData

    suspend fun getParcelList() {
        _trackLiveData.postValue(DataHandler.Loading())
        val response = trackDatabase.trackDao().getAllParcel()

        if (response.isNotEmpty()) {
            _trackLiveData.postValue(DataHandler.Success(response))
        }
        else {
            _trackLiveData.postValue(DataHandler.Error( "LIST IS EMPTY OR NULL"))
        }
    }
}