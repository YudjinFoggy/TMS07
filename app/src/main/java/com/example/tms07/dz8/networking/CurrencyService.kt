package com.example.tms07.dz8.networking

import com.example.tms07.dz8.data.dto.currency.RateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CurrencyService {
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun loadRates(
        @Header("X-CMC_PRO_API_KEY")
        apiKey: String
    ) : Response<RateResponse>
}