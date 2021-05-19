package com.example.tms07.dz8.mappers.currency

import com.example.tms07.dz8.data.dto.currency.RateResponse
import com.example.tms07.dz8.data.entities.currency.Rate
import com.example.tms07.dz8.mappers.Mapper

class RateResponseMapper : Mapper<RateResponse.Data?, Rate> {
    override fun map(from: RateResponse.Data?): Rate {
        return Rate(
            name = from?.name,
            price = from?.quote?.uSD?.price ?: 0.0,
            symbol = from?.symbol,
            percentChange1h = from?.quote?.uSD?.percentChange1h ?: 0.0
        )
    }
}


