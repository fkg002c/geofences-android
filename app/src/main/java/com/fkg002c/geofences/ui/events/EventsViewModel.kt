package com.fkg002c.geofences.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is events fragment"
    }
    val text: LiveData<String> = _text
}