package com.rk.apiintegration.RoomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): Dao

    companion object {

        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            // Only create a new instance if it's not already created
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}
