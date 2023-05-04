package com.saumya.practicaltaskc.network

import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * This class is a helper class for network calls, Which returns a response
 */
interface NetworkService {
    /**
     * This function hits '/api' endpoint and provides a [RandomUserResponse] with a [GET] request
     */
    @GET("/api/")
    suspend fun getRandomUser(): Response<RandomUserResponse>
}