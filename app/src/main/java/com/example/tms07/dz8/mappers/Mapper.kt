package com.example.tms07.dz8.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}