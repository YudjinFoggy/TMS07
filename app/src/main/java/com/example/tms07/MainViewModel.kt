package com.example.tms07

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel : ViewModel() {

    val arrayOfRandomNumbers = (0..3).map { (0..150).random() }
    val timeLeft = MutableLiveData<Int>()
    val productQuantity = MutableLiveData<List<Int>>()


    fun startTimer() {
        object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft.value = millisUntilFinished.toInt().div(1000)
            }

            override fun onFinish() {}
        }.start()
    }

    fun startTimerToGetArrayOfRandomNumbers() {
        viewModelScope.launch {
            delay(Random(1000).nextLong())

            object : CountDownTimer(21000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    productQuantity.value = arrayOfRandomNumbers
                }

                override fun onFinish() {}
            }.start()
        }
    }
}