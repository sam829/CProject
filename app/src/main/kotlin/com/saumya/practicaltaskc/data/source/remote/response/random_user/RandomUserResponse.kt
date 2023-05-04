package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RandomUserResponse(
    @SerializedName("info")
    val infoResponse: InfoResponse,
    @SerializedName("results")
    val resultResponses: List<ResultResponse>
)