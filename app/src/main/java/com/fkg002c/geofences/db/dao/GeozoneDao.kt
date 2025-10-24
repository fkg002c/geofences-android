package com.fkg002c.geofences.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fkg002c.geofences.db.entities.Geozone
import kotlinx.coroutines.flow.Flow

@Dao
interface GeozoneDao {
    @Query("SELECT * FROM geozones_table ORDER BY id ASC")
    fun listFlow(): Flow<List<Geozone>>

    @Query("SELECT * FROM geozones_table ORDER BY id ASC")
    suspend fun getAll(): List<Geozone>

    @Query("SELECT * FROM geozones_table ORDER BY id DESC LIMIT 1")
    suspend fun getLast(): Geozone

    @Query("SELECT * FROM geozones_table where uuid = :uuid")
    suspend fun get(uuid: String): Geozone?

    @Query("DELETE FROM geozones_table")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(geozone: Geozone)

    @Delete
    suspend fun delete(geozone: Geozone)

    @Query("DELETE FROM geozones_table where uuid = :uuid")
    suspend fun delete(uuid: String)

    @Update
    suspend fun update(geozone: Geozone)
}