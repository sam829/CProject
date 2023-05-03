package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class InfoResponse(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)