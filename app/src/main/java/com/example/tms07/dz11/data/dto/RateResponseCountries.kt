package com.example.tms07.dz11.data.dto


import com.google.gson.annotations.SerializedName

data class RateResponseCountries(
    @SerializedName("countries")
    val countries: List<Country?>?,
    @SerializedName("status")
    val status: Int?
) {
    data class Country(
        @SerializedName("code")
        val code: String?,
        @SerializedName("flag")
        val flag: String?,
        @SerializedName("languages")
        val languages: List<String?>?,
        @SerializedName("name")
        val name: String?
    )
}