package com.example.tms07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.collections.ArrayList

class MainViewModelSnowdrop : ViewModel() {

    private val arrSnowdrops = MutableLiveData<ArrayList<Snowdrop>>(ArrayList())

    fun setValuesInFragment(name: String, lengthBuld: Int, length: Int) {
        val snowdrop = Snowdrop()
        snowdrop.name = name
        snowdrop.lengthBuld = lengthBuld
        snowdrop.lengthFlower = length

        arrSnowdrops.value?.add(snowdrop)
    }

    fun getArrSnowdrops(): MutableLiveData<ArrayList<Snowdrop>> {
        return arrSnowdrops
    }
}