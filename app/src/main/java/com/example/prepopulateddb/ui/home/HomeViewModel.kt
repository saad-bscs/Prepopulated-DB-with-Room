package com.example.prepopulateddb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    val trackLiveData get() = homeRepository.trackList

    fun getTrackList() {
        viewModelScope.launch {
            homeRepository.getParcelList()
        }
    }

}