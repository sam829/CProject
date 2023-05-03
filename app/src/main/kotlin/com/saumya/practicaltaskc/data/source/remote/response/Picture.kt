package com.saumya.practicaltaskc.data.source.remote.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)