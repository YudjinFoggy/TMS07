package com.example.tms07.dz11.mappers

import com.example.tms07.dz11.data.dto.RateResponseCountries
import com.example.tms07.dz11.data.entity.RateCountries

class RateResponseCountryMapper : Mapper<RateResponseCountries.Country, RateCountries> {
    override fun map(from: RateResponseCountries.Country?): RateCountries {

        return RateCountries(
            code = from?.code.orEmpty(),
            name = from?.name.orEmpty()
        )
    }
}