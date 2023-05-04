package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class TimezoneResponse(
    val description: String,
    val offset: String
)