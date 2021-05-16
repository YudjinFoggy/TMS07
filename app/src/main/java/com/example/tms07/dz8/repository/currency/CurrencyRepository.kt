package com.example.tms07.dz8.repository.currency

import com.example.tms07.dz8.data.entities.currency.Rate
import com.example.tms07.dz8.mappers.currency.RateResponseMapper
import com.example.tms07.dz8.networking.currency.CurrencyApi

class CurrencyRepository {

    private val api = CurrencyApi.provideRetrofit()
    private val rateResponseMapper = RateResponseMapper()

    suspend fun loadCurrency(periodicity: String): List<Rate> {
        val response = api.loadRates(periodicity)

        return if (response.isSuccessful) {
            response.body()?.data?.map {
                rateResponseMapper.map(it)
            }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }
}