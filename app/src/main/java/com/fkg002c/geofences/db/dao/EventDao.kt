package com.fkg002c.geofences.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fkg002c.geofences.db.entities.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM events_table ORDER BY id ASC")
    fun getAll(): Flow<List<Event>>

    @Query("DELETE FROM events_table")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(geozone: Event) : Long

    @Query("DELETE FROM events_table where geozone_uuid = :uuid")
    suspend fun deleteAllByUuid(uuid: String)
}