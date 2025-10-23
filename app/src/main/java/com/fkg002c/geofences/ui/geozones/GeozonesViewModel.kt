package com.fkg002c.geofences.ui.geozones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GeozonesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is geozones fragment"
    }
    val text: LiveData<String> = _text
}