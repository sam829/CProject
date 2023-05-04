package com.saumya.practicaltaskc.data.source.remote.response.random_user

import androidx.annotation.Keep

@Keep
data class ResultResponse(
    val cell: String,
    val dob: DobResponse,
    val email: String,
    val gender: String,
    val id: IdResponse,
    val location: LocationResponse,
    val login: LoginResponse,
    val name: NameResponse,
    val nat: String,
    val phone: String,
    val picture: PictureResponse,
    val registered: RegisteredResponse
)