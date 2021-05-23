package com.example.tms07.dz9.repository.advice

import com.example.tms07.dz9.data.entities.advice.Rate
import com.example.tms07.dz9.mappers.advice.RateResponseMapper
import com.example.tms07.dz9.networking.advice.AdviceApi


class AdviceRepository {

    private val api = AdviceApi.provideRetrofit()
    private val rateResponseMapper = RateResponseMapper()

    suspend fun loadAdvice(callback: String): Rate {
        val response = api.loadCallback(callback)

        return if (response.isSuccessful) {
                rateResponseMapper.map(response.body())

        } else {
            throw Throwable(response.errorBody().toString())
        }
    }
}