package com.example.tms07.dz9.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}