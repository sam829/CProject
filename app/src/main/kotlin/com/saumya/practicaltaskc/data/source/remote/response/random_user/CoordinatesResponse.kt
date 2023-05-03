package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class CoordinatesResponse(
    val latitude: String,
    val longitude: String
)