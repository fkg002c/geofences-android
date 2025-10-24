package com.fkg002c.geofences.db

import androidx.room.TypeConverter
import java.util.Date

class EventConverters {
    @TypeConverter
    fun dateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun longToDate(date: Long): Date {
        return Date(date)
    }
}