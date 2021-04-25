package com.example.tms07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelHW5 : ViewModel() {

    var loginView = MutableLiveData<String>()

    fun setLogin(login: String) {
        loginView.value = login
    }

    fun getLogin(): MutableLiveData<String> {
        return loginView
    }
}