package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class RegisteredResponse(
    val age: Int,
    val date: String
)