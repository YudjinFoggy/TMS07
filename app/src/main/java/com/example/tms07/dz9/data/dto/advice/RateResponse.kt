package com.example.tms07.dz9.data.dto.advice

import com.google.gson.annotations.SerializedName

data class RateResponse(
    @SerializedName("slip")
    val slip: Slip?
) {
    data class Slip(
        @SerializedName("advice")
        val advice: String?,
        @SerializedName("id")
        val id: Int?
    )
}