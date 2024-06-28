package com.rk.apiintegration.RoomDb

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val firstName: String,
    val lastName: String,
    val age: Int,
)