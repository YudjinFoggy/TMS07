package com.example.tms07.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
data class Car(
    val brand: String,
    val year: Int,
    val price: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    override fun toString(): String {
        return "\nBrand = " + brand +
                ", Year of issue = " + year +
                ", Price = " + price
    }
}