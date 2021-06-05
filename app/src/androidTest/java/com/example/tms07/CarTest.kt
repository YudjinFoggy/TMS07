package com.example.tms07

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tms07.database.MyDatabase
import com.example.tms07.database.dao.CarDao
import com.example.tms07.database.entity.Car
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CarTest {

    private lateinit var car: Car
    private lateinit var carDao: CarDao

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val db = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        carDao = db.carDao()
    }

    @Test
    fun insert_returnTrue() {
        car = Car("Audi", 2016, 250.000)

        runBlocking {
            carDao.insert(car)
            val carList = carDao.getAll()
            Truth.assertThat(carList.contains(car)).isTrue()
        }
    }

    @Test
    fun delete_returnFalse(){
        car = Car("Audi", 2016, 250.000)
        val carBmw = Car("BWM", 2010, 140.000)
        val carMercedes = Car("Mercedes", 2005, 450.000)

        runBlocking {
        carDao.insert(car)
        carDao.insert(carBmw)
        carDao.insert(carMercedes)

        carDao.deleteItem("BWM", 2010, 140.000)
        val carList = carDao.getAll()
        Truth.assertThat(carList.contains(carBmw)).isFalse()
        }
    }

    @Test
    fun searchBrand_returnFalse(){
        car = Car("Audi", 2016, 250.000)
        val carBmw = Car("BWM", 2010, 140.000)
        val carAudi = Car("Audi", 2020, 500.000)
        val carMercedes = Car("Mercedes", 2005, 450.000)

        runBlocking {
            carDao.insert(car)
            carDao.insert(carBmw)
            carDao.insert(carAudi)
            carDao.insert(carMercedes)

            val listOfCarsBySearch = carDao.searchBrand("Audi")
           Truth.assertThat(listOfCarsBySearch.contains(carBmw)).isFalse()
        }
    }

    @Test
    fun searchBrand_returnTrue(){
        car = Car("Audi", 2016, 250.000)
        val carBmw = Car("BWM", 2010, 140.000)
        val carAudi = Car("Audi", 2020, 500.000)
        val carMercedes = Car("Mercedes", 2005, 450.000)

        runBlocking {
            carDao.insert(car)
            carDao.insert(carBmw)
            carDao.insert(carAudi)
            carDao.insert(carMercedes)

            val listOfCarsBySearch = carDao.searchBrand("Audi")
            Truth.assertThat(listOfCarsBySearch.contains(carAudi)).isTrue()
        }
    }

    @Test
    fun getAll_returnTrue() {
        val carBmw = Car("BWM", 2010, 140.000)
        val carAudi = Car("Audi", 2020, 500.000)
        val carMercedes = Car("Mercedes", 2005, 450.000)

        runBlocking {
            carDao.insert(carBmw)
            carDao.insert(carAudi)
            carDao.insert(carMercedes)

            val carList = carDao.getAll()
            Truth.assertThat(carList == carDao.getAll()).isTrue()
        }
    }
}