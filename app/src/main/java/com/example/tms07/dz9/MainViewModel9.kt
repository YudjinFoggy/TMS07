package com.example.tms07.dz9

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms07.dz9.data.entities.advice.Rate

import com.example.tms07.dz9.repository.advice.AdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel9 : ViewModel() {

    private val adviceRepository = AdviceRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _rates = MutableLiveData<Rate>()
    val rates: LiveData<Rate> = _rates

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String> = _errorBus

    val timeLeft = MutableLiveData<Int>()

    fun loadAdvice(callback: String) {

        ioScope.launch {
            try {
                _rates.postValue(adviceRepository.loadAdvice(callback))
            } catch (e: Exception) {
                _errorBus.postValue(e.message)
            }
        }
    }

    fun startTimer() {
        object : CountDownTimer(11000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft.value = millisUntilFinished.toInt().div(1000)
            }

            override fun onFinish() {
                timeLeft.value = 0
            }
        }.start()
    }
}