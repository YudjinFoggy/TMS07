package com.example.tms07.dz11.mappers

interface Mapper<F, T> {
    fun map(from: F?): T
}