package com.example.tms07.dz9.mappers.advice

import com.example.tms07.dz9.data.dto.advice.RateResponse
import com.example.tms07.dz9.data.entities.advice.Rate
import com.example.tms07.dz9.mappers.Mapper

class RateResponseMapper : Mapper<RateResponse?, Rate> {
    override fun map(from: RateResponse?): Rate {
        return Rate(
            advice = from?.slip?.advice.orEmpty()
        )
    }
}