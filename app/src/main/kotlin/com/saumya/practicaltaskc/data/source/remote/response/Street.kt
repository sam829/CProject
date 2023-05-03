package com.saumya.practicaltaskc.data.source.remote.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Street(
    val name: String,
    val number: Int
)