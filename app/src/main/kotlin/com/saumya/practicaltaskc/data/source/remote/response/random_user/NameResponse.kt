package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class NameResponse(
    val first: String,
    val last: String,
    val title: String
)