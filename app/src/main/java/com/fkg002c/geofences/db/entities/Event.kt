package com.fkg002c.geofences.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fkg002c.geofences.db.EventType
import com.google.android.gms.maps.model.LatLng
import java.util.Date

@Entity(tableName = "events_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val date: Date = Date(),
    val type: EventType,
    @ColumnInfo(name = "lat_lng")
    val latLng: LatLng,
    @ColumnInfo(name = "geozone_uuid")
    val geozoneUuid: String,
    @ColumnInfo(name = "geozone_name")
    val geozoneName: String
)