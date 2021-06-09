package com.example.tms07.dz11.mappers

import com.example.tms07.dz11.data.dto.RateResponseHolidays
import com.example.tms07.dz11.data.entity.RateHolidays

class RateResponseHolidayMapper : Mapper<RateResponseHolidays.Holiday, RateHolidays> {
    override fun map(from: RateResponseHolidays.Holiday?): RateHolidays {
        return RateHolidays(
            country = from?.country.orEmpty(),
            date = from?.date.orEmpty(),
            nameHoliday = from?.name.orEmpty()
        )
    }
}