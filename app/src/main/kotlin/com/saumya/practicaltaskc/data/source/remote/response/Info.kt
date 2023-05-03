package com.saumya.practicaltaskc.data.source.remote.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)