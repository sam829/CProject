package com.saumya.practicaltaskc.domain.mappers

import com.saumya.practicaltaskc.data.source.local.entities.RandomUserCache
import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse

/**
 * This file contains mappers for network response and database entity,
 * These are used when we want to have somewhat different properties in database tables and in response.
 * For this current example it is not that useful, As all the properties are same.
 */

fun mapRandomUserToCache(randomUserResponse: RandomUserResponse): RandomUserCache = RandomUserCache(
    infoCache = randomUserResponse.infoResponse,
    resultResponse = randomUserResponse.resultResponses
)

fun mapRandomUserToResponse(randomUserCache: RandomUserCache): RandomUserResponse =
    RandomUserResponse(
        infoResponse = randomUserCache.infoCache,
        resultResponses = randomUserCache.resultResponse
    )
