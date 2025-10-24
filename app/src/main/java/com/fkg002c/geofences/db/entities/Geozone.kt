package com.fkg002c.geofences.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.util.UUID

@Entity(tableName = "geozones_table")
data class Geozone(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val uuid: String = UUID.randomUUID().toString(),
    val name: String,
    @ColumnInfo(name = "lat_lng")
    val latLng: LatLng,
    val radius: Int
)