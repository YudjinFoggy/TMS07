package com.example.tms07.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tms07.database.entity.Car

@Dao
interface CarDao {

    @Insert
    suspend fun insert(car: Car)

    @Query("DELETE FROM car_table WHERE brand == :userBrand and year == :userYear and price == :userPrice")
    suspend fun deleteItem(userBrand: String, userYear: Int, userPrice: Double)

    @Query("SELECT * FROM car_table")
    suspend fun getAll(): List<Car>

    @Query("SELECT * FROM car_table WHERE brand == :userBrand")
    suspend fun searchBrand(userBrand: String) : List<Car>
}