package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class LocationResponse(
    val city: String,
    val coordinates: CoordinatesResponse,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: StreetResponse,
    val timezone: TimezoneResponse
)