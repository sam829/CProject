package com.saumya.practicaltaskc.domain.mappers

import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache
import com.saumya.practicaltaskc.data.source.remote.response.random_user.CoordinatesResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.DobResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.IdResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.InfoResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.LocationResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.LoginResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.NameResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.PictureResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RegisteredResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.ResultResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.StreetResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.TimezoneResponse

/**
 * This file contains mappers for network response and database entity,
 * These are used when we want to have somewhat different properties in database tables and in response.
 * For this current example it is not that useful, As all the properties are same.
 */

fun mapRandomUser(randomUserResponse: RandomUserResponse): RandomUserCache = RandomUserCache(
    infoCache = randomUserResponse.infoResponse,
    resultResponse = randomUserResponse.resultResponses
)