package com.example.tms07.dz11.networking.services

import com.example.tms07.dz11.data.dto.RateResponseCountries
import com.example.tms07.dz11.data.dto.RateResponseHolidays
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("v1/countries")
    fun getCountries(
        @Query("key")
        key: String,
    ): Observable<RateResponseCountries>

    @GET("v1/holidays")
    fun getHolidays(
        @Query("key")
        key: String,
        @Query("country")
        countryCode: String,
        @Query("year")
        year: String,
        @Query("month")
        month: String,
        @Query("day")
        day: String,
        @Query("upcoming")
        upcoming: Boolean = true
    ): Observable<RateResponseHolidays>
}