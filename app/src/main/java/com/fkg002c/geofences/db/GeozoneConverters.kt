package com.fkg002c.geofences.db

import androidx.room.TypeConverter
import com.google.android.gms.maps.model.LatLng

class GeozoneConverters {

    @TypeConverter
    fun latLngToString(latLng: LatLng): String {
        return "(${latLng.latitude},${latLng.longitude})"
    }

    @TypeConverter
    fun stringToLatLng(string: String): LatLng {
        val s = string.replace("(", "").replace(")", "")
        val list = s.split(",")
        return LatLng(list.first().toDouble(), list.last().toDouble())
    }
}