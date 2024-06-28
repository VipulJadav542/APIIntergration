package com.rk.apiintegration.RoomDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT * FROM user_table")
    fun getAll(): List<Entity>

    @Insert
    fun insert(entity: Entity)

    @Delete
    fun delete(entity: Entity)

    @Update
    fun update(entity: Entity)
}