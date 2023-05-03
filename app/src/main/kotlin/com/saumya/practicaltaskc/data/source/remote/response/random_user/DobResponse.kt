package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class DobResponse(
    val age: Int,
    val date: String
)