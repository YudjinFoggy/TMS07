package com.example.tms07.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tms07.database.dao.CarDao
import com.example.tms07.database.entity.Car

@Database(entities = [Car::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {
        var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "database").build()
            }
            return INSTANCE as MyDatabase
        }
    }
}