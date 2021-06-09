package com.example.tms07.dz11.networking.api

import com.example.tms07.dz11.networking.services.Service
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api {

    fun providerRetrofit(): Service{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://holidayapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create()
    }
}