package com.example.tms07

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tms07.database.MyDatabase
import com.example.tms07.database.entity.Car
import com.example.tms07.repository.CarRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel7(application: Application) : AndroidViewModel(application) {

    private val carRepository = CarRepository(MyDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _carList = MutableLiveData<List<Car>>()
    val carList: LiveData<List<Car>> = _carList

    private val _brandList = MutableLiveData<List<Car>>()
    val brandList: LiveData<List<Car>> = _brandList

    fun insert(car: Car) {
        carRepository.insert(car)
    }

    fun deleteItem(serBrand: String, userYear: Int, userPrice: Double) {
        ioScope.launch {
            carRepository.deleteItem(serBrand, userYear, userPrice)
            _carList.postValue(carRepository.loadAll())
        }
    }


    fun loadAllCars() {
        _isLoading.value = true
        ioScope.launch {
            val carList = carRepository.loadAll()
            _carList.postValue(carList)
            _isLoading.postValue(false)
        }
    }

    fun searchBrand(userBrand: String) {
        ioScope.launch {
            val searchBrand = carRepository.searchBrand(userBrand)
            _brandList.postValue(searchBrand)
        }
    }
}