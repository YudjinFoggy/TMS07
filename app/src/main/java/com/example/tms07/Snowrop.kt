package com.example.tms07

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Snowdrop(
    var name: String? = null,
    var lengthBuld: Int? = null,
    var lengthFlower: Int? = null

) : Parcelable {

    override fun toString(): String {
        return "✿.｡..｡..｡.:*✿*:｡..｡..｡.✿]" +
                "\nSnowdrop = " + name +
                "\nLengthBuld = " + lengthBuld +
                "\nLength of flower = " + lengthFlower +
                "\n\n"
    }
}
