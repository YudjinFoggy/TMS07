package com.example.tms07.dz8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms07.dz8.data.entities.currency.Rate
import com.example.tms07.dz8.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel8 : ViewModel(){

    private val currencyRepository = CurrencyRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _rates = MutableLiveData<List<Rate>>()
    val rates: LiveData<List<Rate>> = _rates

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String> = _errorBus

    fun loadRates(periodicity: String) {

        ioScope.launch {
            try {
                _rates.postValue(currencyRepository.loadCurrency(periodicity))
            } catch (e: Exception) {
                _errorBus.postValue(e.message)
            }
        }
    }
}