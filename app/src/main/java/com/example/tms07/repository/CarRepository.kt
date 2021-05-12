package com.example.tms07.repository

import com.example.tms07.database.MyDatabase
import com.example.tms07.database.entity.Car
import kotlinx.coroutines.*

class CarRepository(
    database: MyDatabase
) {

    private val dao = database.carDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(car: Car) {
        ioScope.launch {
            dao.insert(car)
        }
    }

    fun deleteItem(serBrand: String, userYear: Int, userPrice: Double) {
        ioScope.launch {
            dao.deleteItem(serBrand, userYear, userPrice)
        }
    }

    suspend fun loadAll(): List<Car> {
        delay(1000)
        return ioScope.async { dao.getAll() }.await()
    }

    suspend fun searchBrand(userBrand: String): List<Car> {
        return ioScope.async { dao.searchBrand(userBrand) }.await()
    }
}
