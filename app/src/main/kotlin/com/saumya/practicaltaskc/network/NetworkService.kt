package com.saumya.practicaltaskc.network

import com.saumya.practicaltaskc.data.source.remote.response.random_user.RandomUserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * This class is a helper class for network calls, Which returns rxJava observables
 */
interface NetworkService {
    /**
     * This function hits '/api' endpoint and provides a [RandomUserResponse] with a [GET] request
     */
    @GET("/api/")
    fun getRandomUser() : Observable<RandomUserResponse>
}