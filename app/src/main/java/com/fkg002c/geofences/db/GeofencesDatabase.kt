package com.fkg002c.geofences.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fkg002c.geofences.db.dao.EventDao
import com.fkg002c.geofences.db.dao.GeozoneDao
import com.fkg002c.geofences.db.entities.Event
import com.fkg002c.geofences.db.entities.Geozone

@Database(entities = [Geozone::class, Event::class], version = 1, exportSchema = false)
@TypeConverters(value = [GeozoneConverters::class, EventConverters::class])
public abstract class GeofencesDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun geozoneDao(): GeozoneDao

    companion object {
        @Volatile
        private var INSTANCE: GeofencesDatabase? = null

        fun getDatabase(context: Context): GeofencesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GeofencesDatabase::class.java,
                    "geofences_database.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}