package com.example.tms07.dz9.networking

import com.example.tms07.dz9.data.dto.advice.RateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AdviceService {

    @GET("advice?callback")
    suspend fun loadCallback(
        @Query("callback")
        callback: String
    ): Response<RateResponse>
}