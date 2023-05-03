package com.saumya.practicaltaskc.data.source.remote.response


import androidx.annotation.Keep

@Keep
data class RandomUser(
    val info: Info,
    val results: List<Result>
)