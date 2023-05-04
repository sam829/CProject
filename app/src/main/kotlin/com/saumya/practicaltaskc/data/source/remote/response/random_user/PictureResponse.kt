package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class PictureResponse(
    val large: String,
    val medium: String,
    val thumbnail: String
)